import java.util.*;
import java.io.*;

public class Main {

	public static int t, n, m, k;
	public static int[] dy = new int[] { 0, 0, 1, -1 };
	public static int[] dx = new int[] { 1, -1, 0, 0 };

	public static boolean isValid(int y, int x) {
		if (y >= 0 && y < n && x >= 0 && x < m)
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			List<int[]> list = new ArrayList<>();
			int cnt = 0;

			int[][] board = new int[n][m];
			boolean[][] visited = new boolean[n][m];

			for (int j = 0; j < n; j++) {
				Arrays.fill(board[j], 0);
			}
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				board[y][x] = 1;
				list.add(new int[] { y, x });
			}

			Deque<int[]> dq = new ArrayDeque<>();
			for (int[] arr : list) {
				if (!visited[arr[0]][arr[1]]) {
					dq.offer(arr);
					while (!dq.isEmpty()) {
						int[] now = dq.poll();
						for (int j = 0; j < 4; j++) {
							int ny = now[0] + dy[j];
							int nx = now[1] + dx[j];
							if (isValid(ny, nx) && board[ny][nx] == 1 && !visited[ny][nx]) {
								visited[ny][nx] = true;
								dq.offer(new int[] { ny, nx });
							}
						}
					}
					cnt++;
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);

	}
}
