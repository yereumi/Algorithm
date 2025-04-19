import java.util.*;
import java.io.*;

public class Main {
	static int n, m, d;
	static int[][] board, copyBoard;
	static int[] dy = new int[] { 0, -1, 0 };
	static int[] dx = new int[] { -1, 0, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}
	
	static int[] findEnemy(int erosC) {
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][m];
		dq.offer(new int[] { n, erosC, 0 });
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			int r = now[0], c = now[1], dist = now[2];
			
			if (dist > d) break;
			if (r < n && copyBoard[r][c] == 1) return new int[] { r, c };
				
			for (int i = 0; i < 3; i++) {
				int nr = r + dy[i], nc = c + dx[i];
				
				if (isValid(nr, nc) && !visited[nr][nc]) {
					dq.offer(new int[] { nr, nc, dist + 1 });
					visited[nr][nc] = true;
				}
			}
		}
		return new int[] { -1, -1 };
	}
	
	static void copyBoard() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copyBoard[i][j] = board[i][j];
			}
		}
	}
	
	static void moveBoard() {
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < m; j++) {
				copyBoard[i][j] = copyBoard[i - 1][j];
			}
		}
		for (int i = 0; i < m; i++) {
			copyBoard[0][i] = 0;
		}
	}
	
	static int play(int[] eros) {
		int enemy = 0;
		copyBoard = new int[n][m];
		copyBoard();
		for (int i = 0; i < n; i++) {
			Set<String> enemies = new HashSet<>();
			for (int j = 0; j < 3; j++) {
				int[] e = findEnemy(eros[j]);
				if (e[0] == -1 && e[1] == -1) continue;
				enemies.add(e[0] + "," + e[1]);
			}
			enemy += enemies.size();
			for (String e : enemies) {
				String[] yx = e.split(",");
                int r = Integer.parseInt(yx[0]);
                int c = Integer.parseInt(yx[1]);
				copyBoard[r][c] = 0;
			}
			moveBoard();
		}
		return enemy;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < m; j++) {
				for (int k = j + 1; k < m; k++) {
					answer = Math.max(answer, play(new int[] { i, j, k }));
				}
			}
		}
		System.out.println(answer);
	}
}