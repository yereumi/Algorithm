import java.util.*;
import java.io.*;

public class Main {

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
	static int n;
	
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int[] dx = new int[] { -1, 1, 0, 0 };
	
	static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < n;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (true) {
			n = read();
			if (n == 0) break;
			int[][] board = new int[n][n];
			int[][] weight = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					board[i][j] = read();
					weight[i][j] = Integer.MAX_VALUE;
				}
			}
			
			weight[0][0] = board[0][0];
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
			pq.offer(new int[] { 0, 0, weight[0][0] });
			while (!pq.isEmpty()) {
				int[] now = pq.poll();
				int y = now[0];
				int x = now[1];
				int w = now[2];
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (isValid(ny, nx) && !visited[ny][nx]) {
						weight[ny][nx] = Math.min(weight[ny][nx], w + board[ny][nx]);
						pq.offer(new int[] { ny, nx, weight[ny][nx] });
						visited[ny][nx] = true;
					}
				}
			}
			sb.append("Problem ").append(t++).append(": ").append(weight[n - 1][n - 1]).append("\n");
		}
		System.out.println(sb);
	}
}
