import java.util.*;
import java.io.*;

public class Main {

	static int N, answer;
	static int[][] board;
	static boolean[][] visited;
	
	static int[] dr = { -1, -1, 1, 1 };
	static int[] dc = { -1, 1, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	static void backtracking(int idx, int cnt) {
	    if (idx >= N * N) {
	        answer = Math.max(answer, cnt);
	        return;
	    }

	    int r = idx / N;
	    int c = idx % N;
	    int next;

	    if (c == N - 1 && N % 2 == 0) next = idx + 1;
	    else if (c == N - 2 && N % 2 == 0) next = idx + 3;
	    else next = idx + 2;

	    backtracking(next, cnt);

	    if (isPossible(r, c)) {
	        visited[r][c] = true;
	        backtracking(next, cnt + 1);
	        visited[r][c] = false;
	    }
	}
	
	static boolean isPossible(int r, int c) {		
		if (board[r][c] != 1) return false;
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 4; j++) {
				int nr = r + dr[j] * i;
				int nc = c + dc[j] * i;
				
				if (!isValid(nr, nc)) continue;
				
				if (visited[nr][nc]) return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visited = new boolean[N][N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = 0;
		backtracking(0, 0);
		int black = answer;

		answer = 0;
		backtracking(1, 0);
		int white = answer;

		System.out.println(black + white);	
	}
}
