import java.util.*;
import java.io.*;

public class Main {
	
	static int h, w;
	static char[][] board;
	static boolean[][] visited;
	static int[] dy = new int[] { -1, 1, 0, 0 };
	static int[] dx = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int y, int x) {
		return y >= 0 && y < h && x >= 0 && x < w;
	}
	
	static void bfs(int y, int x) {
		Deque<int[]> dq = new ArrayDeque<>();
		
		dq.offer(new int[] { y, x });
		visited[y][x] = true;
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			
			for (int k = 0; k < 4; k++) {
				int ny = now[0] + dy[k];
				int nx = now[1] + dx[k];
				if (isValid(ny, nx) && board[ny][nx] == '#' && !visited[ny][nx]) {
					dq.offer(new int[] { ny, nx });
					visited[ny][nx] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int k = 0; k < t; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			board = new char[h][w];
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					board[i][j] = str.charAt(j);
				}
			}
			
			int cnt = 0;
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (board[i][j] == '#' && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}