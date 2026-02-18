import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, R, answer;
	static int[][] board;
	static int[][] result;
	
	static boolean isValid(int r, int c) {
		return r > 0 && r <= N && c > 0 && c <= M;
	}
	
	static void attack(int r, int c, String d) {
		if (result[r][c] == -1) return;
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { r, c, board[r][c] });
		boolean[][] visited = new boolean[N + 1][M + 1];
		visited[r][c] = true;
		result[r][c] = -1;
		answer++;
		
		if (d.equals("E")) {
			while (!dq.isEmpty()) {
				int[] cur = dq.poll();
				
				for (int i = 1; i < cur[2]; i++) {
					int nr = cur[0];
					int nc = cur[1] + i;
					
					if (!isValid(nr, nc) || visited[nr][nc] || result[nr][nc] == -1) continue;
					
					dq.offer(new int[] { nr, nc, board[nr][nc] });
					result[nr][nc] = -1;
					answer++;
				}
			}
		} else if (d.equals("W")) {
			while (!dq.isEmpty()) {
				int[] cur = dq.poll();
				
				for (int i = 1; i < cur[2]; i++) {
					int nr = cur[0];
					int nc = cur[1] - i;
					
					if (!isValid(nr, nc) || visited[nr][nc] || result[nr][nc] == -1) continue;
					
					dq.offer(new int[] { nr, nc, board[nr][nc] });
					result[nr][nc] = -1;
					answer++;
				}
			}
		} else if (d.equals("S")) {
			while (!dq.isEmpty()) {
				int[] cur = dq.poll();
				
				for (int i = 1; i < cur[2]; i++) {
					int nr = cur[0] + i;
					int nc = cur[1];
					
					if (!isValid(nr, nc) || visited[nr][nc] || result[nr][nc] == -1) continue;
					
					dq.offer(new int[] { nr, nc, board[nr][nc] });
					result[nr][nc] = -1;
					answer++;
				}
			}
		} else if (d.equals("N")) {
			while (!dq.isEmpty()) {
				int[] cur = dq.poll();
				
				for (int i = 1; i < cur[2]; i++) {
					int nr = cur[0] - i;
					int nc = cur[1];
					
					if (!isValid(nr, nc) || visited[nr][nc] || result[nr][nc] == -1) continue;
					
					dq.offer(new int[] { nr, nc, board[nr][nc] });
					result[nr][nc] = -1;
					answer++;
				}
			}
		}
	}
	
	static void defense(int r, int c) {
		if (result[r][c] != -1) return;
		
		result[r][c] = 0;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N + 1][M + 1];
        result = new int[N + 1][M + 1];
        
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 1; j <= M; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for (int i = 0; i < R; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	String d = st.nextToken();
        	attack(x, y, d);
        	
        	st = new StringTokenizer(br.readLine());
        	x = Integer.parseInt(st.nextToken());
        	y = Integer.parseInt(st.nextToken());
        	defense(x, y);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= M; j++) {
        		sb.append(result[i][j] == -1 ? "F" : "S").append(" ");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
