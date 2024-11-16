import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static boolean isValid(int y, int x) {
		return (y >= 0 && y < n && x >= 0 && x < m);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { 0, 0, 1 });
		visited[0][0] = true;
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			if (now[0] == n - 1 && now[1] == m - 1) {
				System.out.println(now[2]);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if (isValid(ny, nx) && map[ny][nx] != 0 && !visited[ny][nx]) {
					dq.offer(new int[] { ny, nx, now[2] + 1 });
					visited[ny][nx] = true;
				}
			}
		}
	}
}
