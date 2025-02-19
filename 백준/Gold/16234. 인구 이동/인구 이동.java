import java.util.*;
import java.io.*;

public class Main {

	static int n, l, r, total;
	static boolean flag;
	static int[][] country;
	static boolean[][] visited;
	static Set<int[]> set;

	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int[] dx = new int[] { -1, 1, 0, 0 };

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	public static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < n;
	}

	public static void bfs(int depth) {
		int y = depth / n;
		int x = depth % n;
		if (visited[y][x]) return;
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { y, x });
		visited[y][x] = true;
		total += country[y][x];
		set.add(new int[] { y, x });

		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];

				if (isValid(ny, nx) && !visited[ny][nx]) {
					int distance = Math.abs(country[now[0]][now[1]] - country[ny][nx]);
					if (distance >= l && distance <= r) {
						flag = true;
						visited[ny][nx] = true;
						dq.offer(new int[] { ny, nx });
						total += country[ny][nx];
						set.add(new int[] { ny, nx });
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		n = read();
		l = read();
		r = read();
		country = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				country[i][j] = read();
			}
		}
		int depth = 0;
		int cnt = 0;
		flag = true;
		while (flag) {
			depth = 0;
			flag = false;
			visited = new boolean[n][n];
			while (depth < n * n) {
				set = new HashSet<>();
				total = 0;
				bfs(depth);
				for (int[] now : set) {
					country[now[0]][now[1]] = total / set.size();
				}
				depth++;
			}
			if (flag) cnt++;
		}
		System.out.println(cnt);
	}
}

/**
9 1 2
1 2 3 4 5 6 7 8 9
4 5 6 7 8 9 1 2 3
3 4 5 6 7 8 9 1 2
2 3 4 1 2 3 4 5 6
3 4 5 8 9 1 2 3 4
5 5 5 5 5 1 2 4 4
1 1 1 1 2 3 4 5 6
9 8 7 6 5 4 3 3 3
2 3 4 1 2 3 4 5 6
*/