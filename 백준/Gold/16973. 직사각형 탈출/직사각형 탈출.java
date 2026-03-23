import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, H, W, SR, SC, FR, FC;
	static int[][] board;
	static int[][] prefix;
	static boolean[][] visited;
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	static void init() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				prefix[i][j] = board[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
			}
		}
	}
	
	static int bfs() {
		int answer = -1;
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { SR, SC, 0 });
		visited[SR][SC] = true;
		
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i], nc = cur[1] + dc[i], nd = cur[2] + 1;
				int r1 = nr, c1 = nc, r2 = nr + H - 1, c2 = nc + W - 1;

				if (!isValid(nr, nc)) continue;
				if (!isValid(r2, c2)) continue;
				if (visited[nr][nc]) continue;

				if (nr == FR && nc == FC) return nd;

				int sum = prefix[r2 + 1][c2 + 1] - prefix[r1][c2 + 1] - prefix[r2 + 1][c1] + prefix[r1][c1];
				if (sum > 0) continue;
				
				dq.offer(new int[] { nr, nc, nd });
				visited[nr][nc] = true;
			}
		}
		
		return answer;
	}
	
    public static void main(String[] args) throws Exception {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	board = new int[N][M];
    	prefix = new int[N + 1][M + 1];
    	visited = new boolean[N][M];
    	
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < M; j++) {
    			board[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	init();
    	
    	st = new StringTokenizer(br.readLine());
    	H = Integer.parseInt(st.nextToken());
    	W = Integer.parseInt(st.nextToken());
    	SR = Integer.parseInt(st.nextToken()) - 1;
    	SC = Integer.parseInt(st.nextToken()) - 1;
    	FR = Integer.parseInt(st.nextToken()) - 1;
    	FC = Integer.parseInt(st.nextToken()) - 1;
    	
    	System.out.println(bfs());
    }
}
