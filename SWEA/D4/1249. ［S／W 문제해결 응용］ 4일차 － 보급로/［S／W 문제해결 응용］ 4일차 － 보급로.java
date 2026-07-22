import java.io.*;
import java.util.*;

class Solution {
    
	static int N;
	static int[][] map;
	static int[][] time;
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	public static void main(String args[]) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			time = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(time[i], Integer.MAX_VALUE);
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
			pq.offer(new int[] { 0, 0, 0 });
			time[0][0] = 0;
			
			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];
					
					if (!isValid(nr, nc)) continue;
					if (time[nr][nc] <= cur[2] + map[nr][nc]) continue;
					
					pq.offer(new int[] { nr, nc, cur[2] + map[nr][nc] });
					time[nr][nc] = cur[2] + map[nr][nc];
				}
			}
			
			sb.append("#" + t + " " + time[N - 1][N - 1]).append('\n');
		}
		
		System.out.println(sb.toString());
    }
}
