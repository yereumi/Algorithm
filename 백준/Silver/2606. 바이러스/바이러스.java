import java.util.*;
import java.io.*;

public class Main {

	public static int n;

	public static int[] dy = new int[] { 0, 0, 1, -1 };
	public static int[] dx = new int[] { 1, -1, 0, 0 };

	public static boolean isValid(int y, int x) {
		if (y >= 0 && y < n && x >= 0 && x < n)
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < e; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			board[y - 1][x - 1] = 1;
			board[x - 1][y - 1] = 1;
		}

		Deque<int[]> dq = new ArrayDeque<>();
		Set<Integer> set = new HashSet<>();
		dq.offer(new int[] { 0, 0 });
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < n; j++) {
					int ny = now[0] + dy[i] * j;
					int nx = now[1] + dx[i] * j;
					if (isValid(ny, nx) && !visited[ny][nx] && board[ny][nx] == 1) {
						visited[ny][nx] = true;
						visited[nx][ny] = true;
						dq.offer(new int[] { ny, nx });
//						System.out.println(ny + " " + nx);
						set.add(ny);
						set.add(nx);
					}
				}
			}
		}
		if (!set.isEmpty()) {
			System.out.println(set.size() - 1);
		} else {
			System.out.println(0);
		}
	}
}
