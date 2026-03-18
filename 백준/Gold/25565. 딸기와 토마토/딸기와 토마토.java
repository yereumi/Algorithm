import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K;
	static boolean[][] board;
	static int[][] seeds; // 비어있으면 0, 딸기는 1, 토마토는 2, 둘다는 3
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	static void strawberry() {
		for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		if (board[i][j]) {
        			if (moveRight(i, j)) {
        				for (int k = 0; k < K; k++) {
        					int nr = i;
        					int nc = j + k;
        					
        					seeds[nr][nc] = 1;
        				}
        				
        				return;
        			};
        			
        			if (moveDown(i, j)) {
        				for (int k = 0; k < K; k++) {
        					int nr = i + k;
        					int nc = j;
        					
        					seeds[nr][nc] = 1;
        				}
        				
        				return;
        			};
        		}
        	}
        }
	}
	
	static void tomato() {
		for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		if (board[i][j]) {
        			if (moveRight(i, j)) {
        				for (int k = 0; k < K; k++) {
        					int nr = i;
        					int nc = j + k;
        					
        					seeds[nr][nc] = seeds[nr][nc] == 1 ? 3 : 2;
        				}
        				
        				if (checkBlank()) {
        					return;
        				}
        				
        				for (int k = 0; k < K; k++) {
        					int nr = i;
        					int nc = j + k;
        					
        					seeds[nr][nc] = seeds[nr][nc] == 3 ? 1 : 0;
        				}
        			};
        			
        			if (moveDown(i, j)) {
        				for (int k = 0; k < K; k++) {
        					int nr = i + k;
        					int nc = j;
        					
        					seeds[nr][nc] = seeds[nr][nc] == 1 ? 3 : 2;
        				}
        				
        				if (checkBlank()) {
        					return;
        				}
        				
        				for (int k = 0; k < K; k++) {
        					int nr = i + k;
        					int nc = j;
        					
        					seeds[nr][nc] = seeds[nr][nc] == 3 ? 1 : 0;
        				}
        			};
        		}
        	}
        }
	}
	
	static boolean moveRight(int r, int c) {
		for (int i = 0; i < K; i++) {
			int nr = r;
			int nc = c + i;
			
			if (!isValid(nr, nc)) return false;
			if (!board[nr][nc]) return false;
		}
		
		return true;
	}
	
	static boolean moveDown(int r, int c) {
		for (int i = 0; i < K; i++) {
			int nr = r + i;
			int nc = c;
			
			if (!isValid(nr, nc)) return false;
			if (!board[nr][nc]) return false;
		}
		
		return true;
	}
	
	static boolean checkBlank() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] && seeds[i][j] == 0) return false;
			}
		}
		
		return true;
	}
	
    public static void main(String[] args) throws Exception {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];
        seeds = new int[N][M];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < M; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
        	}
        }
        
        strawberry();
        tomato();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        	if (o1[0] != o2[0]) return o1[0] - o2[0];
        	return o1[1] - o2[1];
        });
        
        int cnt = 0;
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		if (seeds[i][j] == 3) {
        			pq.offer(new int[] { i + 1, j + 1 });
        			cnt++;
        		}
        	}
        }
        
        sb.append(cnt).append("\n");
        while (!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	sb.append(cur[0] + " " + cur[1]).append("\n");
        }
        
        System.out.println(sb.toString()); 
        
    }
}
