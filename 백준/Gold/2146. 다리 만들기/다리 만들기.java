import java.util.*;
import java.io.*;

public class Main {

	static int n, shore, min;
	static int[][] board;
	static boolean[][] visited;
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}
	
	static void bfs(int r, int c) {
		Deque<int[]> coast = new ArrayDeque<>();
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { r, c });
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			boolean flag = false;
			
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				
				if (isValid(nr, nc)) {
					if (board[nr][nc] == 1 && !visited[nr][nc]) {
						dq.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
					
					if (board[nr][nc] == 0) flag = true;
				}	
			}
			
			if (flag) {
				board[now[0]][now[1]] = shore;
				coast.offer(new int[] { now[0], now[1], 0 });
			}
		}
		
		boolean[][] coastVisited = new boolean[n][n];
		while (!coast.isEmpty()) {
        	int[] now = coast.poll();
        	
        	for (int i = 0; i < 4; i++) {
        		int nr = now[0] + dr[i];
        		int nc = now[1] + dc[i];
        		int nd = now[2] + 1;
        		
        		if (isValid(nr, nc)) {
        			if (board[nr][nc] == 0 && !coastVisited[nr][nc]) {
        				coast.offer(new int[] { nr, nc, nd });
        				coastVisited[nr][nc] = true;
        			}
        			
        			if (!visited[nr][nc] && !coastVisited[nr][nc] && board[nr][nc] == 1) {
            			min = Math.min(min, nd - 1);
            		}
        		}
        	}
        }
	}
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < n; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        shore = -1;
        min = Integer.MAX_VALUE;
		visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (!visited[i][j] && board[i][j] == 1) { // 새로운 육지 발견
        			visited[i][j] = true;
        			bfs(i, j);
        			shore--;
        		}
        	}
        }
        
        System.out.println(min);
    }
}