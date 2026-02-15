import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] board;
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	static int[][][] tetromino = {
		    // ---- I
		    {{0,0},{0,1},{0,2},{0,3}},
		    {{0,0},{1,0},{2,0},{3,0}},

		    // ---- O
		    {{0,0},{0,1},{1,0},{1,1}},

		    // ---- L 계열
		    {{0,0},{1,0},{2,0},{2,1}},
		    {{0,1},{1,1},{2,1},{2,0}},
		    {{0,0},{0,1},{1,0},{2,0}},
		    {{0,0},{0,1},{1,1},{2,1}},
		    {{0,0},{0,1},{0,2},{1,0}},
		    {{0,0},{0,1},{0,2},{1,2}},
		    {{0,0},{1,0},{1,1},{1,2}},
		    {{0,2},{1,0},{1,1},{1,2}},

		    // ---- S 계열
		    {{0,0},{0,1},{1,1},{1,2}},
		    {{0,1},{1,0},{1,1},{2,0}},
		    {{0,1},{0,2},{1,0},{1,1}},
		    {{0,0},{1,0},{1,1},{2,1}},

		    // ---- T 계열
		    {{0,0},{0,1},{0,2},{1,1}},
		    {{0,1},{1,0},{1,1},{2,1}},
		    {{1,0},{1,1},{1,2},{0,1}},
		    {{0,0},{1,0},{2,0},{1,1}}
		};
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < M; j++) {
		        for (int s = 0; s < 19; s++) {

		            int sum = 0;
		            boolean valid = true;

		            for (int k = 0; k < 4; k++) {
		                int nr = i + tetromino[s][k][0];
		                int nc = j + tetromino[s][k][1];

		                if (!isValid(nr, nc)) {
		                    valid = false;
		                    break;
		                }

		                sum += board[nr][nc];
		            }

		            if (valid) max = Math.max(max, sum);
		        }
		    }
		}
		
		System.out.println(max);
		br.close();
	}
}
