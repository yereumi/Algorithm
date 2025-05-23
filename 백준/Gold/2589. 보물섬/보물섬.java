import java.util.*;
import java.io.*;

public class Main {
	
	static int r, c, max;
	static char[][] board;
	static boolean[][] visited;
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < r && nc >= 0 && nc < c;
	}
	
	static void bfs(int r, int c) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { r, c, 0 });
		visited[r][c] = true;
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();

			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				int nd = now[2] + 1;
				
				if (isValid(nr, nc) && board[nr][nc] == 'L' && !visited[nr][nc]) {
					dq.offer(new int[] { nr, nc, nd });
					visited[nr][nc] = true;
					max = Math.max(max, nd);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = str.charAt(j);
			}
		}
        
		max = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j] == 'L') {
					visited = new boolean[r][c];
					bfs(i, j);
				}
			}
		}
		System.out.println(max);
	}
}