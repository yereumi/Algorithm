import java.util.*;
import java.io.*;

public class Main {
	static int R, C;
	static int[][] water;
	static char[][] board;
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int[] dx = new int[] { 1, -1, 0, 0 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
	
	static int moveBeaver(int startR, int startC) {
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[R][C];
		dq.offer(new int[] { startR, startC, 0 });
		visited[startR][startC] = true;
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dy[i], nc = now[1] + dx[i], nt = now[2] + 1;
				if (isValid(nr, nc)) {
					if (!visited[nr][nc] && board[nr][nc] == '.' && nt < water[nr][nc]) {
						visited[nr][nc] = true;
						dq.offer(new int[] { nr, nc, nt });
					}
					if (board[nr][nc] == 'D') return nt;
				}
			}
		}
		return -1;
	}
	
	static void moveWater() {
		Deque<int[]> dq = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == '*') {
					dq.offer(new int[] { i, j, 0 });
					water[i][j] = 0;
				}
			}
		}

		while (!dq.isEmpty()) {
			int[] now = dq.poll();

			for (int k = 0; k < 4; k++) {
				int nr = now[0] + dy[k], nc = now[1] + dx[k], nt = now[2] + 1;
				if (isValid(nr, nc)) {
					if (board[nr][nc] == 'X' || board[nr][nc] == 'D') continue;
					if (nt < water[nr][nc]) {
						water[nr][nc] = nt;
						dq.offer(new int[] { nr, nc, nt });
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		int startR = 0, startC = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
				if (board[i][j] == 'S') {
					startR = i;
					startC = j;
				}
			}
		}
		water = new int[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(water[i], Integer.MAX_VALUE);
		}
		moveWater();
		int answer = moveBeaver(startR, startC);
		if (answer == -1) System.out.println("KAKTUS");
		else System.out.println(answer);
	}
}