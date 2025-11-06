import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[][] board; // 0: 빈 공간, 1: 치즈
	static boolean[][] visited;

	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };

	static boolean isValid(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}

	static void checkOutAir(int r, int c) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { r, c });
		visited[r][c] = true;

		while (!dq.isEmpty()) {
			int[] now = dq.poll();

			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (isValid(nr, nc) && board[nr][nc] == 0 && !visited[nr][nc]) {
					dq.offer(new int[] { nr, nc });
					board[nr][nc] = -1;
					visited[nr][nc] = true;
				}
			}
		}
	}

	static void checkMeltCheese(int r, int c) {
		int cnt = 0;
		for (int j = 0; j < 4; j++) {
			int nr = r + dr[j];
			int nc = c + dc[j];
			if (isValid(nr, nc) && board[nr][nc] == -1) cnt++;
		}
		if (cnt >= 2) board[r][c] = 2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n][m];
		board[0][0] = -1;
		checkOutAir(0, 0);
		
		int time = 0;
		int cheeseCnt = Integer.MAX_VALUE;

		while (cheeseCnt != 0) {
			cheeseCnt = 0;
			visited = new boolean[n][m];
			
			checkOutAir(0, 0);

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visited[i][j] && board[i][j] == 1) {
						checkMeltCheese(i, j);
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (board[i][j] == 2) board[i][j] = -1;
					if (board[i][j] == 1) cheeseCnt++;
					if (board[i][j] == -1) board[i][j] = 0;
				}
			}

			time++;
		}

		System.out.println(time);
	}
}
