import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, T;
	static int[][] board;
	static int[][] delta = {{0,-1},{0,1},{-1,0},{1,0}};
	
	static class Point {
	    int x, y;

	    Point(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}
	
	static boolean isValid(int r, int c) {
		return r > 0 && r <= N && c > 0 && c <= M;
	}
	
	static void simulation(int x, int d, int k) {
		for (int i = x; i <= N; i += x) {
			if (d == 0) { 
				for (int j = 0; j < k; j++) {
					rotateClockwise(i);
				}
			} else if (d == 1) {
				for (int j = 0; j < k; j++) {
					rotateCounterClockwise(i);
				}
			}
		}
		
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (board[i][j] != -1) flag = true;
			}
		}
		
		if (flag) removeAdjacency();
	}
	
	static void rotateClockwise(int num) {
		int tmp = board[num][M];

		for (int i = M; i > 1; i--) {
			board[num][i] = board[num][i - 1];
		}
		
		board[num][1] = tmp;
	}
	
	static void rotateCounterClockwise(int num) {
		int tmp = board[num][1];

		for (int i = 1; i < M; i++) {
			board[num][i] = board[num][i + 1];
		}
		
		board[num][M] = tmp;
	}
	
	static void removeAdjacency() {
		Set<Point> set = new HashSet<>();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (board[i][j] == -1) continue;
				
				for (int d = 0; d < 4; d++) {
					int nr = i + delta[d][0];
					int nc = j + delta[d][1];

					if (nc > M) nc = 1;
					if (nc < 1) nc = M;
					
					if (!isValid(nr, nc)) continue;
					
					if (board[i][j] == board[nr][nc]) {
						Point p1 = new Point(i, j);
		                Point p2 = new Point(nr, nc);
		                
		                set.add(p1);
		                set.add(p2);
					}
				}
			}
		}
		
		if (set.isEmpty()) {
			double avg = calculateAverage();
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (board[i][j] == -1) continue;
					if (board[i][j] > avg) {
						board[i][j] -= 1;
					} else if (board[i][j] < avg) {
						board[i][j] += 1;
					}
				}
			}
			
			return;
		}
		
		for (Point p : set) {
		    board[p.x][p.y] = -1;
		}
	}
	
	static double calculateAverage() {
		double answer = 0.0;
		int cnt = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (board[i][j] != -1) {
					answer += (double) board[i][j];
					cnt++;
				}
			}
		}
		
		return answer / (double) cnt;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        board = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 1; j <= M; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        while (T-- > 0) {
        	st = new StringTokenizer(br.readLine());
        	
        	int x = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	int k = Integer.parseInt(st.nextToken());
        	
        	simulation(x, d, k);
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (board[i][j] != -1) {
					answer += board[i][j];
				}
			}
		}
        
        System.out.println(answer);
    }
}
