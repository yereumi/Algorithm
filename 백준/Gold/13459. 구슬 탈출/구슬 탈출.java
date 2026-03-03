import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static char[][] board;
	static boolean[][][][] visited;
	static boolean answer;
	static int rR, rC, bR, bC;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static void simulation() {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { rR, rC, bR, bC, 0 });
		visited[rR][rC][bR][bC] = true;
		
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			
			if (cur[4] >= 10) continue;
			
			for (int i = 0; i < 4; i++) {
				int[] red = move(cur[0], cur[1], i);
				int[] blue = move(cur[2], cur[3], i);
				
				 if (board[blue[0]][blue[1]] == 'O') continue;
				 
				 if (board[red[0]][red[1]] == 'O') {
					 answer = true;
					 return;
				 }
				 
				 if (red[0] == blue[0] && red[1] == blue[1]) {
					 if (red[2] > blue[2]) {
						 red[0] -= dr[i];
						 red[1] -= dc[i];
					 } else {
						 blue[0] -= dr[i];
						 blue[1] -= dc[i];
					 }
				 }
				 
				 if (!visited[red[0]][red[1]][blue[0]][blue[1]]) {
					 visited[red[0]][red[1]][blue[0]][blue[1]] = true;
					 dq.offer(new int[] { red[0], red[1], blue[0], blue[1], cur[4] + 1 });
				 }
			}
		}
	}

	static int[] move(int r, int c, int d) {
		int cnt = 0;
		
		while (board[r + dr[d]][c + dc[d]] != '#' && board[r][c] != 'O') {
			r += dr[d];
			c += dc[d];
			cnt++;
		}
		
		return new int[] { r, c, cnt };
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	board = new char[N][M];
    	visited = new boolean[N][M][N][M];
    	
    	for (int i = 0; i < N; i++) {
    		String line = br.readLine();
    		for (int j = 0; j < M; j++) {
    			board[i][j] = line.charAt(j);
    			if (board[i][j] == 'R') {
    				rR = i;
    				rC = j;
    			}
    			if (board[i][j] == 'B') {
    				bR = i;
    				bC = j;
    			}
    		}
    	}
    	
    	answer = false;
    	simulation();
    	
    	System.out.println(answer ? 1 : 0);
    }
}
