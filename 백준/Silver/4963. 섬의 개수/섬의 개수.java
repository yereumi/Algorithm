import java.util.*;
import java.io.*;

public class Main {

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static int w, h;
	static int[][] board;
	static boolean[][] visited;
	static int[] dy = new int[] { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int[] dx = new int[] { -1, 1, 0, 0, -1, 1, 1, -1 };

	static boolean isValid(int y, int x) {
		return y >= 0 && y < h && x >= 0 && x < w;
	}

	public static int bfs(int depth) {
		int y = depth / w;
		int x = depth % w;
		int cnt = 0;
		if (visited[y][x] || board[y][x] == 0)
			return cnt;
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { y, x });
		visited[y][x] = true;
		if (board[y][x] == 1)
			cnt++;

		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			for (int i = 0; i < 8; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if (isValid(ny, nx) && !visited[ny][nx]) {
					visited[ny][nx] = true;
					if (board[ny][nx] == 1) {
						dq.offer(new int[] { ny, nx });
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		while (true) {
			w = read();
			h = read();
			if (w == 0 || h == 0)
				break;
			board = new int[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					board[i][j] = read();
				}
			}
			int depth = 0, cnt = 0;
			while (depth < w * h) {
				cnt += bfs(depth) == 0 ? 0 : 1;
				depth++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
