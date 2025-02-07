import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[][] board;
	static boolean[][] visited;
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int[] dx = new int[] { -1, 1, 0, 0 };

	static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < n && !visited[y][x];
	}

	static int bfs(int y, int x) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { y, x });
		int cnt = 0;
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			int nowY = now[0];
			int nowX = now[1];
			if (board[nowY][nowX] == 1) {
				cnt++;
				for (int i = 0; i < 4; i++) {
					int nextY = nowY + dy[i];
					int nextX = nowX + dx[i];
					if (isValid(nextY, nextX)) {
						dq.offer(new int[] { nextY, nextX });
						visited[nextY][nextX] = true;
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		visited = new boolean[n][n];
		List<Integer> house = new ArrayList<>();
		int depth = 0;
		while (depth < n * n) {
			int y = depth / n;
			int x = depth % n;
			depth++;
			if (visited[y][x]) continue;
			visited[y][x] = true;
			int cnt = bfs(y, x);
			if (cnt != 0) house.add(cnt);
		}
		Collections.sort(house);
		sb.append(house.size()).append("\n");
		for (int i = 0; i < house.size(); i++) {
			sb.append(house.get(i)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
