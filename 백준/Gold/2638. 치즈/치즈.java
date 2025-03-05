import java.util.*;
import java.io.*;

public class Main {

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static int n, m;
	static boolean flag;
	static int[][] cheese;
	static boolean[][] isOuter;

	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int[] dx = new int[] { -1, 1, 0, 0 };

	static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}

	static void checkOuterSpace() {
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][m];
		dq.offer(new int[] { 0, 0 });

		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			int y = now[0];
			int x = now[1];
			isOuter[y][x] = true;

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (isValid(ny, nx) && cheese[ny][nx] == 0 & !visited[ny][nx]) {
					visited[ny][nx] = true;
					dq.offer(new int[] { ny, nx });
				}
			}
		}
	}

	static void changeStatus() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (cheese[i][j] == 2)
					cheese[i][j] = 0;
			}
		}
	}

	static void bfs(int depth) {
		int y = depth / m;
		int x = depth % m;
		int airCnt = 0;

		if (cheese[y][x] == 1) {
			for (int i = 0; i < 4; i++) {
				int ay = y + dy[i];
				int ax = x + dx[i];
				if (isValid(ay, ax) && cheese[ay][ax] == 0 && isOuter[ay][ax]) {
					airCnt++;
				}
			}
			if (airCnt >= 2) {
				cheese[y][x] = 2;
				flag = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		cheese = new int[n][m];
		isOuter = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cheese[i][j] = read();
			}
		}
		int time = 0;
		while (true) {
			flag = true;
			changeStatus();
			checkOuterSpace();
			for (int i = 0; i < n * m; i++) {
				bfs(i);
			}
			if (flag) break;
			time++;
		}
		System.out.println(time);
	}
}
