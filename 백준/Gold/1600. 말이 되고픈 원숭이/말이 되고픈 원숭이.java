import java.util.*;
import java.io.*;

public class Main {
	
	static int k, w, h, min;
	static int[][] board;
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] hr = new int[] { 1, 2, 1, 2, -1, -2, -1, -2 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	static int[] hc = new int[] { -2, -1, 2, 1, -2, -1, 2, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < h && c >= 0 && c < w;
	}
	
	static int bfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { 0, 0, 0, 0 });
		boolean[][][] visited = new boolean[h][w][k + 1];
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				int nh = now[2];
				int nd = now[3] + 1;
				
				if (nr == h - 1 && nc == w - 1) min = Math.min(min, nd);
				if (isValid(nr, nc) && board[nr][nc] == 0 && !visited[nr][nc][nh]) {
					dq.offer(new int[] { nr, nc, nh, nd });
					visited[nr][nc][nh] = true;
				}
			}
			
			if (now[2] < k) {
				for (int i = 0; i < 8; i++) {
					int nr = now[0] + hr[i];
					int nc = now[1] + hc[i];
					int nh = now[2] + 1;
					int nd = now[3] + 1;
					
					if (nr == h - 1 && nc == w - 1) min = Math.min(min, nd);
					if (isValid(nr, nc) && board[nr][nc] == 0 && !visited[nr][nc][nh]) {
						dq.offer(new int[] { nr, nc, nh, nd });
						visited[nr][nc][nh] = true;
					}
				}
			}
			
		}
		
		if (w == 1 && h == 1) return 0;
		if (min == Integer.MAX_VALUE) return -1;
		return min;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		board = new int[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		System.out.println(bfs());
	}
}