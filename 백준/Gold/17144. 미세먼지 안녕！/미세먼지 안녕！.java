import java.util.*;
import java.io.*;

public class Main {
	static int r, c, t, up, down;
	static int[][] board;
	static int[] dr = new int[] { 0, 0, -1, 1 };
	static int[] dc = new int[] { -1, 1, 0, 0 };
	
	static boolean isValid(int nr, int nc) {
		return nr >= 0 && nr < r && nc >= 0 && nc < c;
	}
	
	static int cleanup() {
		int[][] prevBoard = board, nextBoard;
		
		for (int i = 0; i < t; i++) {
			nextBoard = diffusion(prevBoard);
			prevBoard = airPurifier(nextBoard);
			
		}
		int answer = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				answer += prevBoard[i][j];
			}
		}
		return answer;
	}
	
	static int[][] diffusion(int[][] prevBoard) {
		int[][] nextBoard = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (prevBoard[i][j] > 0) {
					int d = prevBoard[i][j] / 5;
					nextBoard[i][j] += prevBoard[i][j];
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k], nc = j + dc[k];
						if (isValid(nr, nc) && prevBoard[nr][nc] != -1) {
							nextBoard[nr][nc] += d;
							nextBoard[i][j] -= d;
						}
					}
				}
			}
		}
        nextBoard[up][0] = nextBoard[down][0] = 0;
		return nextBoard;
	}
	
	static int[][] airPurifier(int[][] prevBoard) {
		int[][] nextBoard = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				nextBoard[i][j] = prevBoard[i][j];
			}
		}
		
		for (int i = 1; i < c; i++) {
			nextBoard[up][i] = prevBoard[up][i - 1];
		}
		if (up >= 1) {
			for (int i = up - 1; i >= 0; i--) {
				nextBoard[i][c - 1] = prevBoard[i + 1][c - 1];
			}
			for (int i = c - 2; i >= 0; i--) {
				nextBoard[0][i] = prevBoard[0][i + 1];
			}
			for (int i = 1; i <= up; i++) {
				nextBoard[i][0] = prevBoard[i - 1][0];
			}
		}
		
		for (int i = 1; i < c; i++) {
			nextBoard[down][i] = prevBoard[down][i - 1];
		}
		if (down <= r - 2) {
			for (int i = down + 1; i < r; i++) {
				nextBoard[i][c - 1] = prevBoard[i - 1][c - 1];
			}
			for (int i = c - 2; i >= 0; i--) {
				nextBoard[r - 1][i] = prevBoard[r - 1][i + 1];
			}
			for (int i = r - 2; i >= down; i--) {
				nextBoard[i][0] = prevBoard[i + 1][0];
			}
		}
		nextBoard[up][0] = nextBoard[down][0] = 0;
		return nextBoard;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		board = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == -1) {
					if (isValid(i - 1, j) && board[i - 1][j] == -1) {
						up = i - 1;
						down = i;
					}
				}
			}
		}
		System.out.println(cleanup());
	}	
}