import java.io.*;
import java.util.*;

public class Main {

	static int n, m, f;
	static int taxiR, taxiC;
	static boolean[][] road;
	static int[][] board, endList;
	
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 1 && r <= n && c >= 1 && c <= n;
	}
	
	static int findCustomer() {
	    Deque<int[]> dq = new ArrayDeque<>();
	    boolean[][] visited = new boolean[n + 1][n + 1];
	    dq.offer(new int[] { taxiR, taxiC, 0 });
	    visited[taxiR][taxiC] = true;

	    List<int[]> candidates = new ArrayList<>();
	    int minDist = Integer.MAX_VALUE;

	    while (!dq.isEmpty()) {
	        int[] now = dq.poll();
	        int r = now[0], c = now[1], dist = now[2];

	        if (dist > minDist) break;

	        if (board[r][c] != 0) {
	            minDist = dist;
	            candidates.add(new int[] { r, c, board[r][c] });
	        }

	        for (int i = 0; i < 4; i++) {
	            int nr = r + dr[i];
	            int nc = c + dc[i];
	            if (isValid(nr, nc) && road[nr][nc] && !visited[nr][nc]) {
	                visited[nr][nc] = true;
	                dq.offer(new int[] { nr, nc, dist + 1 });
	            }
	        }
	    }

	    if (candidates.isEmpty()) return -1;

	    candidates.sort((a, b) -> {
	        if (a[0] != b[0]) return a[0] - b[0];
	        return a[1] - b[1];
	    });

	    int targetR = candidates.get(0)[0];
	    int targetC = candidates.get(0)[1];
	    int idx = candidates.get(0)[2];

	    if (f < minDist) return -1;
	    f -= minDist;
	    taxiR = targetR;
	    taxiC = targetC;
	    board[targetR][targetC] = 0;

	    if (!drive(targetR, targetC, idx)) return -1;
	    return 0;
	}
	
	static boolean drive(int r, int c, int goal) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { r, c, 0 });
        boolean[][] visited = new boolean[n + 1][n + 1];
		visited[r][c] = true;
		
		if (f <= 0) return false;
		
		if (r == endList[goal][0] && c == endList[goal][1]) return true;
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				int nf = now[2] + 1;
				
				if (isValid(nr, nc) && road[nr][nc] && !visited[nr][nc] && nf <= f) {
					if (nr == endList[goal][0] && nc == endList[goal][1]) {
						f += nf;
						taxiR = nr;
						taxiC = nc;
						return true;
					}

					dq.offer(new int[] { nr, nc, nf });
					visited[nr][nc] = true;
				}
			}
		}
		
		return false;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        
        road = new boolean[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
        	Arrays.fill(road[i], true);
        }
        
        for (int i = 1; i <= n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 1; j <= n; j++) {
        		if (Integer.parseInt(st.nextToken()) == 1) road[i][j] = false;
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        taxiR = Integer.parseInt(st.nextToken());
        taxiC = Integer.parseInt(st.nextToken());
        
        board = new int[n + 1][n + 1];
        endList = new int[m + 1][2];
        for (int i = 1; i <= m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int startR = Integer.parseInt(st.nextToken());
    		int startC = Integer.parseInt(st.nextToken());
    		int endR = Integer.parseInt(st.nextToken());
    		int endC = Integer.parseInt(st.nextToken());
    		
    		board[startR][startC] = i;
    		endList[i][0] = endR;
    		endList[i][1] = endC;
        }
        
        int answer = 0;
        for (int i = 0; i < m; i++) {
        	if (findCustomer() == -1) {
        		answer = -1;
        		break;
        	};
        	
        	if (f <= 0) {
        		answer = -1;
        		break;
        	}
        	answer = f;
        }
        
        System.out.println(answer);
    }
}
