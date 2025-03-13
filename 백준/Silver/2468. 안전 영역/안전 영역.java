import java.util.*;
import java.io.*;

public class Main {
    
	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static int n, result, answer;
	static int[][] board;
	static boolean[][] visited;
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int[] dx = new int[] { -1, 1, 0, 0 };

	static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < n;
	}

	static void bfs(int y, int x, int height) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { y, x });
		visited[y][x] = true;
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];

				if (isValid(ny, nx) && !visited[ny][nx] && board[ny][nx] > height) {
	                visited[ny][nx] = true;
	                dq.offer(new int[] { ny, nx });
	            }
			}
		}
	}

	public static void main(String[] args) throws Exception {
		int minHeight = Integer.MAX_VALUE, maxHeight = Integer.MIN_VALUE;
		n = read();
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = read();
				minHeight = Math.min(minHeight, board[i][j]);
		        maxHeight = Math.max(maxHeight, board[i][j]);
			}
		}
		answer = 0;
		for (int i = minHeight - 1; i <= maxHeight; i++) {
			result = 0;
			visited = new boolean[n][n];
			for (int y = 0; y < n; y++) {
		        for (int x = 0; x < n; x++) {
		            if (!visited[y][x] && board[y][x] > i) {
		                bfs(y, x, i);
		                result++;
		            }
		        }
		    }
			answer = Math.max(answer, result);
		}
		System.out.println(answer);
	}
}