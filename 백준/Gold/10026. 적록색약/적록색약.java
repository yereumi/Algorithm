import java.util.*;
import java.io.*;

public class Main {
	
	static int n, normal, blind;
	static char[][] color;
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int[] dx = new int[] { -1, 1, 0, 0 };
	
	static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < n;
	}
	
	static void bfs() {
		boolean[][] visited = new boolean[n][n];
		Deque<int[]> dq = new ArrayDeque<>();
		for (int i = 0; i < n * n; i++) {
			int y = i / n;
			int x = i % n;
			if (!visited[y][x]) {
				normal++;
				visited[y][x] = true;
				dq.offer(new int[] { y, x });
				while (!dq.isEmpty()) {
					int[] now = dq.poll();
					
					for (int j = 0; j < 4; j++) {
						int ny = now[0] + dy[j];
						int nx = now[1] + dx[j];
						if (isValid(ny, nx) && !visited[ny][nx] && color[now[0]][now[1]] == color[ny][nx]) {
							visited[ny][nx] = true;
							dq.offer(new int[] { ny, nx });
						}
					}
				}
			}
		}
	}
	
	static void blindBfs() {
		boolean[][] visited = new boolean[n][n];
		Deque<int[]> dq = new ArrayDeque<>();
		for (int i = 0; i < n * n; i++) {
			int y = i / n;
			int x = i % n;
			if (!visited[y][x]) {
				blind++;
				visited[y][x] = true;
				dq.offer(new int[] { y, x });
				while (!dq.isEmpty()) {
					int[] now = dq.poll();
					
					if (color[now[0]][now[1]] == 'B') {
						for (int j = 0; j < 4; j++) {
							int ny = now[0] + dy[j];
							int nx = now[1] + dx[j];
							if (isValid(ny, nx) && !visited[ny][nx] && color[now[0]][now[1]] == color[ny][nx]) {
								visited[ny][nx] = true;
								dq.offer(new int[] { ny, nx });
							}
						}
					} else {
						for (int j = 0; j < 4; j++) {
							int ny = now[0] + dy[j];
							int nx = now[1] + dx[j];
							if (isValid(ny, nx) && !visited[ny][nx] && (color[ny][nx] == 'G' || color[ny][nx] == 'R')) {
								visited[ny][nx] = true;
								dq.offer(new int[] { ny, nx });
							}
						}
					}
					
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		color = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				color[i][j] = str.charAt(j);
			}
		}
		normal = blind = 0;
		bfs();
		blindBfs();
		System.out.println(normal + " " + blind);
	}
}