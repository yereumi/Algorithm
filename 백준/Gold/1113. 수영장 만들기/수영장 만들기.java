import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static int[][] board;
	static boolean[][] visited;
	static PriorityQueue<int[]> pq;
	static int[] dy = new int[] { -1, 1, 0, 0 };
	static int[] dx = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        pq = new PriorityQueue<>((int[] o1, int[] o2) -> o1[2] - o2[2]);
        
        for (int i = 0; i < n; i++) {
        	String str = br.readLine();
        	for (int j = 0; j < m; j++) {
        		board[i][j] = str.charAt(j) - '0';
        		if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
        			visited[i][j] = true;
        			pq.offer(new int[] { i, j, board[i][j] });
        		}
        	}
        }
        
        int result = 0;
        
        while (!pq.isEmpty()) {
        	int[] now = pq.poll();
        	int h = now[2];
        	
        	for (int i = 0; i < 4; i++) {
        		int ny = now[0] + dy[i];
        		int nx = now[1] + dx[i];
        		
        		if (isValid(ny, nx) && !visited[ny][nx]) {
        			if (board[ny][nx] < h) {
        				result += h - board[ny][nx];
        				pq.offer(new int[] { ny, nx, h });
        			} else {
        				pq.offer(new int[] { ny, nx, board[ny][nx] });
        			}
        			visited[ny][nx] = true;
        		}
        	}
        }
        
        System.out.println(result);
	}
}