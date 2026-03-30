import java.io.*;
import java.util.*;

public class Main {
	
	static int w, h, dustCnt;
	static char[][] board;
	static int[][] idx;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < h && c >= 0 && c < w;
	}

	static int bfs(int s, int e) {
	    int fullMask = (1 << dustCnt) - 1;
	    Deque<int[]> dq = new ArrayDeque<>();
	    boolean[][][] visited = new boolean[h][w][1 << dustCnt];

	    dq.offer(new int[] { s, e, 0, 0 }); // r, c, dist, mask
	    visited[s][e][0] = true;

	    while (!dq.isEmpty()) {
	        int[] cur = dq.poll();

	        int r = cur[0];
	        int c = cur[1];
	        int dist = cur[2];
	        int mask = cur[3];

	        if (mask == fullMask) return dist;

	        for (int i = 0; i < 4; i++) {
	            int nr = r + dr[i];
	            int nc = c + dc[i];

	            if (!isValid(nr, nc)) continue;
	            if (board[nr][nc] == 'x') continue;

	            int nextMask = mask;

	            if (idx[nr][nc] != -1) {
	                nextMask |= (1 << idx[nr][nc]);
	            }

	            if (visited[nr][nc][nextMask]) continue;

	            visited[nr][nc][nextMask] = true;
	            dq.offer(new int[] { nr, nc, dist + 1, nextMask });
	        }
	    }

	    return -1;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 || h == 0) break;
			
			board = new char[h][w];
			idx = new int[h][w];
			for (int i = 0; i < h; i++) {
			    Arrays.fill(idx[i], -1);
			}
 
			int s = 0, e = 0, dustIdx = 0;
			dustCnt = 0;
			for (int i = 0; i < h; i++) {
				String line = br.readLine();
				for (int j = 0; j < w; j++) {
					board[i][j] = line.charAt(j);
					if (board[i][j] == 'o') {
						s = i;
						e = j;
					} else if (board[i][j] == '*') {
						idx[i][j] = dustIdx++;
						dustCnt++;
					}
				}
			}
			
			sb.append(bfs(s, e)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
