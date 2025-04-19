/**
 * 시간 2초: 2억번 안에 연산
 * 최대 메모리 256MB: int 기준 대략 256 * 1000 * 1000 / 4 = 64_000_000개 할당 가능
 * 1<=N, L<=1000 -> O(N^3)까지 가능
 */
import java.util.*;
import java.io.*;

public class Main {
	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
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
//		System.out.println("===" + eros[0] + " " + eros[1] + " " + eros[2] + "===");
		for (int i = 0; i < n; i++) {
			Set<String> enemies = new HashSet<>();
			for (int j = 0; j < 3; j++) {
				int[] e = findEnemy(eros[j]);
				if (e[0] == -1 && e[1] == -1) continue;
				enemies.add(e[0] + "," + e[1]);
//				System.out.print(e[0] + "," + e[1] + " ");
			}
			enemy += enemies.size();
			for (String e : enemies) {
				String[] yx = e.split(",");
				copyBoard[Integer.parseInt(yx[0])][Integer.parseInt(yx[1])] = 0;
			}
			moveBoard();
//			System.out.println();
		}
//		System.out.println(enemy);
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