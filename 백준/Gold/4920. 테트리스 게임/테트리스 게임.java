import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] board;
	static int[][][] bar = new int[][][] { { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } },
			{ { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } },
			{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } }, { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } } };

	static boolean isValid(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}

	static int tetris() {
		int max = Integer.MIN_VALUE;;
		for (int p = 0; p < 5; p++) {
			int[][] now = new int[4][2];
			for (int i = 0; i < 4; i++) {
			    now[i][0] = bar[p][i][0];
			    now[i][1] = bar[p][i][1];
			}
			
			for (int q = 0; q < 4; q++) {
				int minR = Integer.MAX_VALUE;
				int minC = Integer.MAX_VALUE;
				
				for (int i = 0; i < 4; i++) {
					minR = Math.min(minR, now[i][0]);
					minC = Math.min(minC, now[i][1]);
				}
				
				for (int i = 0; i < 4; i++) {
					now[i][0] -= minR;
					now[i][1] -= minC;
				}

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						boolean flag = true;
						int sum = 0;

						for (int k = 0; k < 4; k++) {
							int r = now[k][0] + i;
							int c = now[k][1] + j;

							if (!isValid(r, c)) {
								flag = false;
								break;
							}

							sum += board[r][c];
						}
						
						if (flag) max = Math.max(max, sum);
					}
				}
				now = rotate(now);
			}			
		}

		return max;
	}

	static int[][] rotate(int[][] now) {
		int[][] next = new int[4][2];
		
		for (int i = 0; i < 4; i++) {
			next[i][0] = now[i][1];
			next[i][1] = now[i][0] * -1;
		}
		
		return next;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int idx = 1;
		while (true) {
			n = Integer.parseInt(br.readLine().trim());

			if (n == 0)
				break;

			board = new int[n][n];
			StringTokenizer st;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append(idx++ + ". " + tetris()).append("\n");
		}

		System.out.println(sb);
	}
}
