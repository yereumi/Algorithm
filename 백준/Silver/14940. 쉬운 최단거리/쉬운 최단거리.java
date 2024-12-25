import java.util.*;
import java.io.*;

public class Main {

	public static int n, m, y, x;
	public static int[][] board;
	public static int[] dy = new int[] { 0, 0, 1, -1 };
	public static int[] dx = new int[] { 1, -1, 0, 0 };
	public static Deque<int[]> dq = new ArrayDeque<>();

	public static boolean isValid(int y, int x) {
		if (y >= 0 && y < n && x >= 0 && x < m)
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] result = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(result[i], -1);
		}
		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					y = i;
					x = j;
				}
				if (board[i][j] == 0) {
					result[i][j] = 0;
				}
			}
		}

		dq.offer(new int[] { y, x });
		result[y][x] = 0;
		visited[y][x] = true;
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if (isValid(ny, nx) && board[ny][nx] != 0 && !visited[ny][nx]) {
					result[ny][nx] = result[now[0]][now[1]] + 1;
					dq.offer(new int[] { ny, nx });
					visited[ny][nx] = true;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(result[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
