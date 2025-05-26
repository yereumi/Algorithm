import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static char[][] board;
	static int[] start;
	static boolean[][][] visited;
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}
	
	static int bfs() {
		visited = new boolean[n][m][64];
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { start[0], start[1], 0, 0 });
		visited[start[0]][start[1]][0] = true;
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
						
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				int nk = now[2];
				int nd = now[3] + 1;
				
				if (isValid(nr, nc)) {
					if (board[nr][nc] == '1') return now[3] + 1;

					if ((board[nr][nc] == '.' || board[nr][nc] == '0') && !visited[nr][nc][nk]) {
						dq.offer(new int[] { nr, nc, nk, nd });
						visited[nr][nc][nk] = true;
					}
					if (board[nr][nc] >= 'a' && board[nr][nc] <= 'f' && !visited[nr][nc][nk]) {
						nk |= (1 << (board[nr][nc] - 'a'));
						dq.offer(new int[] { nr, nc, nk, nd });
						visited[nr][nc][nk] = true;
					}
					if (board[nr][nc] >= 'A' && board[nr][nc] <= 'F' && !visited[nr][nc][nk]) {
						if ((nk & (1 << (board[nr][nc] - 'A'))) == 0) continue;
						dq.offer(new int[] { nr, nc, nk, nd });
						visited[nr][nc][nk] = true;
					}
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		start = new int[2];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = str.charAt(j);
				if (board[i][j] == '0') {
					start[0] = i;
					start[1] = j;
				}
			}
		}
		
		System.out.println(bfs());
		
	}
}