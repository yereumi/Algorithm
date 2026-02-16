import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, answer;
	static int[][] board;
	static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	static void simulation(int idx, char[][] newBoard) {
		if (idx >= N * M) {
			answer = Math.min(answer, countZero(newBoard));
			return;
		}
		
		int r = idx / M;
		int c = idx % M;
		int num = board[r][c];
		
		if (num == 0 || num == 6) simulation(idx + 1, newBoard);
		
		if (num == 1) {
			for (int i = 0; i < 4; i++) {
				
				simulation(idx + 1, moveOne(r, c, copyBoard(newBoard), i));
			}
		} else if (num == 2) {
			for (int i = 0; i < 2; i++) {
				simulation(idx + 1, moveTwo(r, c, copyBoard(newBoard), i));
			}
		} else if (num == 3) {
			for (int i = 0; i < 4; i++) {
				simulation(idx + 1, moveThree(r, c, copyBoard(newBoard), i));
			}
		} else if (num == 4) {
			for (int i = 0; i < 4; i++) {
				simulation(idx + 1, moveFour(r, c, copyBoard(newBoard), i));
			}
		} else if (num == 5) {
			simulation(idx + 1, moveFive(r, c, copyBoard(newBoard)));
		}
	}
	
	static char[][] copyBoard(char[][] board) {
		char[][] newBoard = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}
	
	static char[][] moveOne(int r, int c, char[][] newBoard, int d) {
		int[] dt = delta[d];
		int nr = r + dt[0], nc = c + dt[1];
		
		while (isValid(nr, nc) && board[nr][nc] != 6) {
			newBoard[nr][nc] = '#';
			nr += dt[0];
			nc += dt[1];
		}
		
		return newBoard;
	}
	
	static char[][] moveTwo(int r, int c, char[][] newBoard, int d) {
		int[] dt = delta[d];
		int nr = r + dt[0], nc = c + dt[1];
		
		while (isValid(nr, nc) && board[nr][nc] != 6) {
			newBoard[nr][nc] = '#';
			nr += dt[0];
			nc += dt[1];
		}
		
		dt = delta[(d + 2) % 4];
		nr = r + dt[0];
		nc = c + dt[1];
		
		while (isValid(nr, nc) && board[nr][nc] != 6) {
			newBoard[nr][nc] = '#';
			nr += dt[0];
			nc += dt[1];
		}
		
		return newBoard;
	}
	
	static char[][] moveThree(int r, int c, char[][] newBoard, int d) {
		for (int i = 0; i < 2; i++) {
			int[] dt = delta[(d + i) % 4];
			int nr = r + dt[0], nc = c + dt[1];
			
			while (isValid(nr, nc) && board[nr][nc] != 6) {
				newBoard[nr][nc] = '#';
				nr += dt[0];
				nc += dt[1];
			}
		}
		
		return newBoard;
	}
	
	static char[][] moveFour(int r, int c, char[][] newBoard, int d) {
		for (int i = 0; i < 3; i++) {
			int[] dt = delta[(d + i) % 4];
			int nr = r + dt[0], nc = c + dt[1];
			
			while (isValid(nr, nc) && board[nr][nc] != 6) {
				newBoard[nr][nc] = '#';
				nr += dt[0];
				nc += dt[1];
			}
		}
		
		return newBoard;
	}
	
	static char[][] moveFive(int r, int c, char[][] newBoard) {
		for (int i = 0; i < 4; i++) {
			int[] dt = delta[i];
			int nr = r + dt[0], nc = c + dt[1];
			
			while (isValid(nr, nc) && board[nr][nc] != 6) {
				newBoard[nr][nc] = '#';
				nr += dt[0];
				nc += dt[1];
			}
		}
		
		return newBoard;
	}
	
	
	static int countZero(char[][] newBoard) {
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (newBoard[i][j] == '0') cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
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
		
		answer = Integer.MAX_VALUE;
		char[][] newBoard = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newBoard[i][j] = (char) (board[i][j] + '0');
			}
		}
		
		simulation(0, newBoard);
		
		System.out.println(answer);
		br.close();
	}
}
