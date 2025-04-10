/**
 * 시간 1초: 1억번 안에 연산
 * 최대 메모리 128MB: int 기준 대략 128 * 1000 * 1000 / 4 = 32_000_000개 할당 가능
 */
import java.util.*;
import java.io.*;

public class Main {
	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static int m, n, k;
	static boolean[][] board;
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int[] dx = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int y, int x) {
		return y >= 0 && y < m && x >= 0 && x < n;
	}
	
	static int bfs(int y, int x) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { y, x });
		board[y][x] = true;
		int cnt = 0;
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			cnt++;
			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i], nx = now[1] + dx[i];
				if (isValid(ny, nx) && !board[ny][nx]) {
					dq.offer(new int[] { ny, nx });
					board[ny][nx] = true;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		m = read();
		n = read();
		k = read();
		board = new boolean[m][n];
		while (k-- > 0) {
			int x1 = read(), y1 = read(), x2 = read(), y2 = read();
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					board[j][i] = true;
				}
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!board[i][j]) list.add(bfs(i, j));
			}
		}
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for (int l : list) sb.append(l).append(" ");
		System.out.println(sb);
	}
}