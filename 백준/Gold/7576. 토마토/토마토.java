import java.util.*;
import java.io.*;

public class Main {

	public static int m, n;
	public static int[][] tomato;
	public static int[] dy = new int[] { 0, 0, 1, -1 };
	public static int[] dx = new int[] { 1, -1, 0, 0 };
	public static Deque<int[]> dq = new ArrayDeque<>();

	public static boolean isValid(int y, int x) {
		if (y >= 0 && y < n && x >= 0 && x < m && tomato[y][x] != -1)
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		tomato = new int[n][m];
		int cntZero = 0;
		int day = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 0)
					cntZero++;
				if (tomato[i][j] == 1)
					dq.offer(new int[] { i, j });
			}
		}

		Deque<int[]> tomatoList = new ArrayDeque<>(dq);
		Deque<int[]> addedTomato = new ArrayDeque<>();

		if (cntZero == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		while (!tomatoList.isEmpty()) {
			addedTomato = new ArrayDeque<>(tomatoList);
			tomatoList.clear();
			while (!addedTomato.isEmpty()) {
				int[] newTomato = addedTomato.poll();
				for (int i = 0; i < 4; i++) {
					int nextY = newTomato[0] + dy[i];
					int nextX = newTomato[1] + dx[i];
					if (isValid(nextY, nextX) && tomato[nextY][nextX] != 1) {
						tomato[nextY][nextX] = 1;
						tomatoList.add(new int[] { nextY, nextX });
					}
				}
			}
			if (!tomatoList.isEmpty()) {
				day++;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tomato[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		
		System.out.println(day);
	}
}
