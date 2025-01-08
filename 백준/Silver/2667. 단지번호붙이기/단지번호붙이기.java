import java.io.*;
import java.util.*;

public class Main {
	
	public static int[] dx = new int[] { 0, 0, -1, 1 };
	public static int[] dy = new int[] { -1, 1, 0, 0 };
	
	
	public static int n;
	public static int[][] board;
	public static boolean[][] visited;
	public static List<Integer> list = new ArrayList<>();
	
	public static boolean isValid(int y, int x) {
		if (y >= 0 && y < n && x >= 0 && x < n) return true;
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(Character.toString(s.charAt(j)));
			}
		}
		
		Deque<int[]> dq = new ArrayDeque<>();
		for (int i = 0; i < n * n; i++) {
			int y = i / n;
			int x = i % n;
			
			if (visited[y][x]) continue;
			if (board[y][x] == 0) {
				visited[y][x] = true;
				continue;
			}
			
			int cnt = 0;
			dq.offer(new int[] { y, x });
			while (!dq.isEmpty()) {
				int[] now = dq.poll();
				int ny = now[0];
				int nx = now[1];
				if (!visited[ny][nx] && board[ny][nx] == 1) {
					cnt++;
					visited[ny][nx] = true;
					for (int j = 0; j < 4; j++) {
						int nny = ny + dy[j];
						int nnx = nx + dx[j];
						if (isValid(nny, nnx)) {
							dq.offer(new int[] { nny, nnx });
						}
					}
				}
			}
			list.add(cnt);
		}
		
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}
