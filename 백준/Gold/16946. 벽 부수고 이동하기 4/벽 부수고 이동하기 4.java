import java.util.*;
import java.io.*;

public class Main {

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static int n, m, groupIdx = 2;
	static int[] group;
	static int[][] board, groupBoard;
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int[] dx = new int[] { -1, 1, 0, 0 };

	static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}

	public static void countZero(int y, int x) {
		int cnt = 1;
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { y, x });
		groupBoard[y][x] = groupIdx;
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if (isValid(ny, nx) && board[ny][nx] == 0 && groupBoard[ny][nx] == 0) {
					dq.offer(new int[] { ny, nx });
					groupBoard[ny][nx] = groupIdx;
					cnt++;
				}
			}
		}
		group[groupIdx] = cnt;
		groupIdx++;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = read();
		m = read();
		board = new int[n][m];
		groupBoard = new int[n][m];
		group = new int[n * m * 2 + 2];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0 && groupBoard[i][j] == 0) {
					countZero(i, j);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 1) {
					Set<Integer> set = new HashSet<>();
					for (int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if (isValid(ny, nx)) {
							int gid = groupBoard[ny][nx];
                            if (gid > 0 && set.add(gid)) {  // 중복 그룹 제외
                                board[i][j] += group[gid];
                            }
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(board[i][j] % 10);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
