import java.util.*;
import java.io.*;

public class Main {
	
	static int w, h, startX, startY;
	static char[][] board;
	static int[][] time;
	static boolean[][] visited;
	static Deque<int[]> dq;
	static StringBuilder sb = new StringBuilder();
	static int[] dx = new int[] { 0, 0, -1, 1 };
	static int[] dy = new int[] { -1, 1, 0, 0 };
	
	static boolean isValid(int x, int y) {
		return x >= 0 && x < h && y >= 0 && y < w;
	}
	
	static void start() {
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				int nt = now[2] + 1;
				
				if (isValid(nx, ny) && board[nx][ny] != '#' && time[nx][ny] > nt) {
					time[nx][ny] = nt;
					dq.offer(new int[] { nx, ny, nt });
				}
			}
		}
	}
	
	static void bfs() {
		dq.offer(new int[] { startX, startY, 0 });
		visited[startX][startY] = true;
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				int nt = now[2] + 1;
				
				if (!isValid(nx, ny)) {
					sb.append(nt).append("\n");
					return;
				}
				if (isValid(nx, ny) && board[nx][ny] != '#' && !visited[nx][ny] && nt < time[nx][ny]) {
					dq.offer(new int[] { nx, ny, nt });
					visited[nx][ny] = true;
				}
			}
		}
		
		sb.append("IMPOSSIBLE").append("\n");
		return;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            board = new char[h][w];
            time = new int[h][w];
            for (int i = 0; i < h; i++) {
            	Arrays.fill(time[i], Integer.MAX_VALUE);
            }
            visited = new boolean[h][w];
            dq = new ArrayDeque<>();
            
            for (int i = 0; i < h; i++) {
            	String line = br.readLine();
            	for (int j = 0; j < w; j++) {
            		board[i][j] = line.charAt(j);
            		if (board[i][j] == '@') {
            			startX = i;
            			startY = j;
            		}
            		if (board[i][j] == '*') {
            			dq.offer(new int[] { i, j, 0 });
            			time[i][j] = 0;
            		}
            	}
            }
            
            start();
            bfs();
        }
        
        System.out.println(sb);
    }
}