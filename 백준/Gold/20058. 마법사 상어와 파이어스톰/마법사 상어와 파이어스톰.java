import java.io.*;
import java.util.*;

public class Main {
	
	static int N, Q, num;
	static int[][] board;
	static boolean[][] visited;

	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < num && c >= 0 && c < num;
	}
	
	static void firestorm(int L) {
		int n = (int) Math.pow(2, L);
		int[][] next = new int[num][num];
		for (int i = 0; i < num; i += n) {
			for (int j = 0; j < num; j += n) {
				for (int p = 0; p < n; p++) {
		            for (int q = 0; q < n; q++) {
		                next[i + q][j + (n - 1 - p)] = board[i + p][j + q];
		            }
		        }
			}
		}
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				board[i][j] = next[i][j];
			}
		}
	}
	
	static void melt() {
		Deque<int[]> dq = new ArrayDeque<>();
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					
					if (isValid(nr, nc) && board[nr][nc] > 0) cnt++;
				}
				
				if (board[i][j] > 0 && cnt < 3) dq.offer(new int[] { i, j });
			}
		}
		
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			board[cur[0]][cur[1]]--;
		}
	}
	
	static int ice(int r, int c) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { r, c });
		int cnt = 0;
		
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			cnt++;
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if (isValid(nr, nc) && !visited[nr][nc] && board[nr][nc] > 0) {
					dq.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}
		
		return cnt;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        num = (int) Math.pow(2, N);
        
        board = new int[num][num];
        for (int i = 0; i < num; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < num; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
        	int L = Integer.parseInt(st.nextToken());
        	firestorm(L);
        	melt();
        }
        
        int sum = 0;
        for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				sum += board[i][j];
			}
		}
        
        int max = 0;
        visited = new boolean[num][num];
        for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (!visited[i][j] && board[i][j] > 0) {
				    visited[i][j] = true;
				    max = Math.max(max, ice(i, j));
				}
			}
		}
        
        System.out.println(sum + "\n" + max);
    }
}
