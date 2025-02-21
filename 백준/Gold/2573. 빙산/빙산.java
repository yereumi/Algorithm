import java.util.*;
import java.io.*;

public class Main {

	/**
	 * 1. bfs로 순회하면서 빙산의 개수 줄이기 -> 다른 이차원 배열에 저장
	 * 2. 빙산의 개수 세기 -> boolean으로 저장해서 while문 종료 조건
	 * 3. 전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않으면 0 출력
	 */

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static int n, m;
	static int[][] board;
	static boolean[][] visited;

	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int[] dx = new int[] { -1, 1, 0, 0 };

	private static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}

	private static void bfs() {
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], false);
		}
		
		for (int i = 0; i < n * m; i++) {
			int y = i / m;
			int x = i % m;
			if (board[y][x] == 0)
				continue;

			int cnt = 0;
			visited[y][x] = true;
			for (int j = 0; j < 4; j++) {
				int ny = y + dy[j];
				int nx = x + dx[j];
				if (isValid(ny, nx) && !visited[ny][nx] && board[ny][nx] == 0) {
					cnt++;
				}
			}
			board[y][x] = board[y][x] - cnt < 0 ? 0 : board[y][x] - cnt;
		}
	}

	private static int count() {
		int cnt = 0;
		Deque<int[]> dq = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], false);
		}
		
		for (int i = 0; i < n * m; i++) {
			int y = i / m;
			int x = i % m;
			if (board[y][x] == 0 || visited[y][x]) continue;
			
			cnt++;
			dq.offer(new int[] { y, x });
			while (!dq.isEmpty()) {
				int[] now = dq.poll();
				for (int j = 0; j < 4; j++) {
					int ny = now[0] + dy[j];
					int nx = now[1] + dx[j];
					if (isValid(ny, nx) && !visited[ny][nx] && board[ny][nx] != 0) {
						dq.offer(new int[] { ny, nx });
						visited[ny][nx] = true;
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		board = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = read();
			}
		}
        
		int year = 0;
		while (true) {
			int cnt = count();
			if (cnt >= 2) break;
			if (cnt == 0) {
				year = 0;
				break;
			}
			bfs();
			year++;
		}
		System.out.println(year);
	}
}
