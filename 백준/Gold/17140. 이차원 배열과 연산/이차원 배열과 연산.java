import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	static int r, c, k;
	static int[][] num;

	public static void simulation() {
		boolean rc = isRowOrColumn();
		if (rc) rowCal();
		else colCal();
	}

	public static boolean isRowOrColumn() {
		int maxR = 0, maxC = 0;

		for (int i = 0; i < 100; i++) {
			int r = 0, c = 0;

			for (int j = 0; j < 100; j++) {
				if (num[i][j] != 0) c++;
				if (num[j][i] != 0) r++;
			}

			maxR = Math.max(maxR, r);
			maxC = Math.max(maxC, c);
		}

		if (maxR >= maxC) return true;
		return false;
	}

	public static void rowCal() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[1] == o2[1]) return o1[0] - o2[0];
			return o1[1] - o2[1];
		});

		for (int i = 0; i < 100; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < 100; j++) {
				if (num[i][j] == 0) continue;
				map.put(num[i][j], map.getOrDefault(num[i][j], 0) + 1);
			}

			for (Entry<Integer, Integer> m : map.entrySet()) {
				pq.offer(new int[] { m.getKey(), m.getValue() });
			}

			int idx = 0;
			while (!pq.isEmpty()) {
				int[] now = pq.poll();
				if (idx >= 100) break;
				num[i][idx] = now[0];
				num[i][idx + 1] = now[1];
				idx += 2;
			}
			
			for (int j = idx; j < 100; j++) num[i][j] = 0;
		}
	}

	public static void colCal() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[1] == o2[1])
				return o1[0] - o2[0];
			return o1[1] - o2[1];
		});

		for (int i = 0; i < 100; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < 100; j++) {
				if (num[j][i] == 0) continue;
				map.put(num[j][i], map.getOrDefault(num[j][i], 0) + 1);
			}

			for (Entry<Integer, Integer> m : map.entrySet()) {
				pq.offer(new int[] { m.getKey(), m.getValue() });
			}

			int idx = 0;
			while (!pq.isEmpty()) {
				int[] now = pq.poll();

				if (idx >= 100) break;
				num[idx][i] = now[0];
				num[idx + 1][i] = now[1];
				idx += 2;
			}

			for (int j = idx; j < 100; j++) num[j][i] = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		num = new int[100][100];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;

		while (true) {
			if (num[r - 1][c - 1] == k)
				break;
			if (time > 100) {
				time = -1;
				break;
			}
			simulation();
			time++;
		}

		System.out.println(time);
	}
}
