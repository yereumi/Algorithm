import java.util.*;
import java.io.*;

public class Main {
    
	static StringBuilder sb;

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		int n = read();
		int m = read();
		long[][] board = new long[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(board[i], Integer.MAX_VALUE);
			board[i][i] = 0L;
		}
		for (int i = 0; i < m; i++) {
			int a = read();
			int b = read();
			int c = read();
			board[a][b] = Math.min(board[a][b], c);
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (board[i][j] > 100_000_000) sb.append(0).append(" ");
				else sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}