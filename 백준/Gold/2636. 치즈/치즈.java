import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] board;
	static boolean[][] visited;
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}
	
	private static int piece() {
		int answer = 0;
		
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 1 && !visited[i][j]) {
					answer++;
				}
				visited[i][j] = true;
			}
		}
		
		return answer;
	}
	
	private static void melt() {
		visited = new boolean[n][m];
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { 0, 0 });
		visited[0][0] = true;
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				
				if (isValid(nr, nc) && !visited[nr][nc]) {
					if (board[nr][nc] == 0) {
						dq.offer(new int[] { nr, nc });
					} else {
						board[nr][nc] = 0;
					}
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int prevPiece = 0;
		int piece = 0;
		int year = 0;
		while (true) {
			prevPiece = piece;
			piece = piece();
			if (piece == 0) break;
			melt();
			year++;
		}
		
		System.out.println(year);		
		System.out.println(prevPiece);
	}
}
