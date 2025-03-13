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

	static void bfs(int height, int depth) {
		int y = depth / n;
		int x = depth % n;
		if (visited[y][x] || board[y][x] <= height) return;

		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { y, x });
		visited[y][x] = true;
		while (!dq.isEmpty()) {
			int[] now = dq.poll();

			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];

				if (isValid(ny, nx) && !visited[ny][nx]) {
					visited[ny][nx] = true;
					if (board[ny][nx] > height) dq.offer(new int[] { ny, nx });
				}
			}
		}
		result++;
	}

	public static void main(String[] args) throws Exception {
		n = read();
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = read();
			}
		}
		answer = 0;
		for (int i = 0; i <= 100; i++) {
			result = 0;
			visited = new boolean[n][n];
			for (int j = 0; j < n * n; j++) {
				bfs(i, j);
			}
			answer = Math.max(answer, result);
		}
		System.out.println(answer);
	}
}