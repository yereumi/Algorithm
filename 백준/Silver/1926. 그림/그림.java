import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m, max;
	static int[][] board;
	static boolean[][] visited;
	static int[] dy = new int[] { -1, 1, 0, 0 };
	static int[] dx = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}
	
	static void bfs(int y, int x) {
		Deque<int[]> dq = new ArrayDeque<>();
		
		dq.offer(new int[] { y, x });
		visited[y][x] = true;
		
		int extent = 1;
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				
				if (isValid(ny, nx) && board[ny][nx] == 1 && !visited[ny][nx]) {
					dq.offer(new int[] { ny, nx });
					visited[ny][nx] = true;
					extent++;
				}
			}
		}
		
		max = Math.max(max, extent);
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = max = 0;
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt).append("\n").append(max);
		
		System.out.println(sb);
	}
}