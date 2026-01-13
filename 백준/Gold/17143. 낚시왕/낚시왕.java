import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C, M, answer;
	static int[][] board;
	static int[][] sharks;
	
	public static void simulation() {
		for (int i = 1; i <= C; i++) {
			for (int j = 1; j <= R; j++) {
				if (board[j][i] == 0) continue;
				
				int shark = board[j][i];
				answer += sharks[shark][4];
				sharks[shark][0] = -1;
				sharks[shark][1] = -1;
				board[j][i] = 0;
				break;
			}
			
			move();
		}
	}
	
	public static void move() {
		int[][] newBoard = new int[R + 1][C + 1];
		
		for (int i = 1; i <= M; i++) {
			int r = sharks[i][0];
			int c = sharks[i][1];
			int s = sharks[i][2];
			int d = sharks[i][3];
			int z = sharks[i][4];
			
			if (r == -1 || c == -1) continue;
			
			while (s-- > 0) {
			    if (d == 1) {
			        if (r == 1) {
			            d = 2;
			            r++;
			        } else {
			            r--;
			        }
			    } else if (d == 2) {
			        if (r == R) {
			            d = 1;
			            r--;
			        } else {
			            r++;
			        }
			    } else if (d == 3) {
			        if (c == C) {
			            d = 4;
			            c--;
			        } else {
			            c++;
			        }
			    } else {
			        if (c == 1) {
			            d = 3;
			            c++;
			        } else {
			            c--;
			        }
			    }
			}
			
			int prev = newBoard[r][c];
	        if (prev == 0) {
	            newBoard[r][c] = i;
	            sharks[i][0] = r;
	            sharks[i][1] = c;
	            sharks[i][3] = d;
	        } else {
	            if (sharks[prev][4] < z) {
	                sharks[prev][0] = -1;
	                sharks[prev][1] = -1;

	                newBoard[r][c] = i;
	                sharks[i][0] = r;
	                sharks[i][1] = c;
	                sharks[i][3] = d;
	            } else {
	                sharks[i][0] = -1;
	                sharks[i][1] = -1;
	            }
	        }
		}
		
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				board[i][j] = newBoard[i][j];
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	board = new int[R + 1][C + 1];
    	sharks = new int[M + 1][5];
    	
    	for (int i = 1; i <= M; i++) {
    		st = new StringTokenizer(br.readLine());
    		sharks[i][0] = Integer.parseInt(st.nextToken());
    		sharks[i][1] = Integer.parseInt(st.nextToken());
    		sharks[i][2] = Integer.parseInt(st.nextToken()); // 속력
    		sharks[i][3] = Integer.parseInt(st.nextToken()); // 이동 방향
    		sharks[i][4] = Integer.parseInt(st.nextToken()); // 크기
    		
    		board[sharks[i][0]][sharks[i][1]] = i;
    	}
    	
    	answer = 0;
    	
    	simulation();
    	
    	System.out.println(answer);
    }
}
