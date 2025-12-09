import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static char[][] board;
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        for (int i = 0; i < n; i++) {
        	String input = br.readLine();
        	for (int j = 0; j < m; j++) {
        		board[i][j] = input.charAt(j);
        	}
        }
        
        int time = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
        	Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dq.offer(new int[] { x1 - 1, y1 - 1 });
        dist[x1 - 1][y1 - 1] = 0;
        
        while (!dq.isEmpty()) {
        	int[] now = dq.poll();
        	if (board[now[0]][now[1]] == '#') {
        		time = dist[now[0]][now[1]] + 1;
        		break;
        	}
        	
        	for (int i = 0; i < 4; i++) {
        		int nr = now[0] + dr[i];
        		int nc = now[1] + dc[i];
        		
        		if (!isValid(nr, nc)) continue;
        		if (dist[nr][nc] <= dist[now[0]][now[1]] + 1) continue;
        		
        		if (board[nr][nc] == '1') {
        			dq.offer(new int[] { nr, nc });
        			dist[nr][nc] = dist[now[0]][now[1]] + 1;
    			} else {
    				dq.push(new int[] { nr, nc });
    				dist[nr][nc] = dist[now[0]][now[1]];
    			}
        	}
        }
        
        System.out.println(time);
    }
}
