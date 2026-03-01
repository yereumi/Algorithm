import java.util.*;
import java.io.*;

public class Main {
	
	static int R, C, N;
	static boolean[][] board;
	static int[][] time;
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
	
	static void add() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!board[i][j]) {
					board[i][j] = true;
					time[i][j] = 3;
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (time[i][j] != -1) {
					time[i][j]--;
				}
			}
		}
	}
	
	static void bomb() {
		Deque<int[]> dq = new ArrayDeque<>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (time[i][j] == 0) {
					dq.offer(new int[] { i, j });
				}
			}
		}
		
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			
			board[cur[0]][cur[1]] = false;
			time[cur[0]][cur[1]] = -1;
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if (isValid(nr, nc) && board[nr][nc]) {
					board[nr][nc] = false;
					time[nr][nc] = -1;
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (time[i][j] != -1) {
					time[i][j]--;
				}
			}
		}
	}
	
	static void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < R; i++) {
        	for (int j = 0; j < C; j++) {
        		sb.append(board[i][j] ? 'O' : '.');
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb.toString());
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new boolean[R][C];
        time = new int[R][C];
        
        for (int i = 0; i < R; i++) {
        	Arrays.fill(time[i], -1);
        }
        
        for (int i = 0; i < R; i++) {
        	String str = br.readLine();
        	for (int j = 0; j < C; j++) {
        		board[i][j] = str.charAt(j) == 'O' ? true : false;
        		if (board[i][j]) time[i][j] = 2;
        	}
        }
        
        for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (time[i][j] != -1) {
					time[i][j]--;
				}
			}
		}
        
        if (N == 1) {
        	print();
        	return;
        }
        
        int idx = 0;
        while (true) {
        	if (idx < N - 1) {
        		add();
        	} else break;
        	idx++;
        	
        	if (idx < N - 1) {
        		bomb();
        	} else break;
        	idx++;
        }
        
        print();
    }
}
