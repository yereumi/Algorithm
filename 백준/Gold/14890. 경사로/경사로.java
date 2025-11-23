import java.util.*;
import java.io.*;

public class Main {
	
	static int n, l;
	static int[][] board;
	static boolean[][] visited;
	
	static boolean isValid(int r, int c, boolean isRow) {
		if (isRow) {
			if (Math.abs(board[r][c - 1] - board[r][c]) != 1) return false;
			
			boolean isUp = board[r][c] - board[r][c - 1] == 1;
			
			if (isUp) {
				for (int i = c - 1; i >= c - l; i--) {
					if (i < 0) return false;
					if (visited[r][i]) return false;
					if (board[r][i] != board[r][c] - 1) {
						return false;
					}
				}
				for (int i = c - 1; i >= c - l; i--) {
					visited[r][i] = true;
				}
			} else {
				for (int i = c; i < c + l; i++) {
					if (i >= n) return false;
					if (visited[r][i]) return false;
					if (board[r][i] != board[r][c - 1] - 1) {
						return false;
					}
				}
				for (int i = c; i < c + l; i++) {
					visited[r][i] = true;
				}
			}
		} else {
			if (Math.abs(board[r][c] - board[r - 1][c]) != 1) return false;
			
			boolean isUp = board[r][c] - board[r - 1][c] == 1;
			
			if (isUp) {
				for (int i = r - 1; i >= r - l; i--) {
					if (i < 0) return false;
					if (visited[i][c]) return false;
					if (board[i][c] != board[r][c] - 1) {
						return false;
					}
				}
				for (int i = r - 1; i >= r - l; i--) {
					visited[i][c] = true;
				}
			} else {
				for (int i = r; i < r + l; i++) {
					if (i >= n) return false;
					if (visited[i][c]) return false;
					if (board[i][c] != board[r - 1][c] - 1) {
						return false;
					}
				}
				for (int i = r; i < r + l; i++) {
					visited[i][c] = true;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

        board = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;

		// 가로
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = 1; j < n; j++) {
				if (board[i][j - 1] != board[i][j]) {
					if (!isValid(i, j, true)) {
						flag = false;
						break; 
					}
				}
			}
			
			if (flag) answer++;	
		}
		
		// 세로
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = 1; j < n; j++) {
				if (board[j - 1][i] != board[j][i]) {
					if (!isValid(j, i, false)) {
						flag = false;
						break; 
					}
				}
			}
			
			if (flag) answer++;	
		}
		
		System.out.println(answer);
	}
}
