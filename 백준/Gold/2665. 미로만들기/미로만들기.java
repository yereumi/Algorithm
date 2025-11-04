import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static boolean[][] board;
	static int[][] dist;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static boolean isValid(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = str.charAt(j) - '0' == 0 ? false : true;
			}
		}
		
		dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{ 0, 0 });
        
        while (!dq.isEmpty()) {
        	int[] now = dq.pollFirst();
        	int r = now[0];
        	int c = now[1];
        	
        	for (int i = 0; i < 4; i++) {
        		int nr = r + dr[i];
        		int nc = c + dc[i];
        		
        		if (!isValid(nr, nc)) continue;
        		
        		int cost = board[nr][nc] ? 0 : 1;
        		if (dist[nr][nc] > dist[r][c] + cost) {
        			dist[nr][nc] = dist[r][c] + cost;
        			if (cost == 0) dq.addFirst(new int[] { nr, nc });
        			else dq.addLast(new int[] { nr, nc });
        		}
        	}
        }

        System.out.println(dist[n - 1][n - 1]);
	}
}
