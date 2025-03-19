import java.util.*;
import java.io.*;

public class Main {
    
	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
	static int n, m, maxArea;
	static int[][] board, tmpBoard;
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int[] dx = new int[] { -1, 1, 0, 0 };
	
	static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}
	
	static void virus() {
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][m];
		tmpBoard = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmpBoard[i][j] = board[i][j];
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && tmpBoard[i][j] == 2) {
					dq.offer(new int[] { i, j });
					visited[i][j] = true;
					while (!dq.isEmpty()) {
						int[] now = dq.poll();
						int nowY = now[0];
						int nowX = now[1];
						for (int k = 0; k < 4; k++) {
							int nextY = nowY + dy[k];
							int nextX = nowX + dx[k];
							if (isValid(nextY, nextX) && !visited[nextY][nextX] && tmpBoard[nextY][nextX] == 0) {
								tmpBoard[nextY][nextX] = 2;
								dq.offer(new int[] { nextY, nextX });
								visited[nextY][nextX] = true;
							}
						}
					}
				}
			}
		}
	}
	
	static void checkSafe() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmpBoard[i][j] == 0) cnt++;
			}
		}
		maxArea = Math.max(maxArea, cnt);
	}
	
	static boolean dfs(int depth) {
		if (depth == 3) {
			virus();
			checkSafe();
			return true;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0) {
					board[i][j] = 1;
					dfs(depth + 1);
					board[i][j] = 0;
				}
			}
		}
        return true;
	}

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = read();
			}
		}
		maxArea = 0;
		dfs(0);
		System.out.println(maxArea);
	}
}