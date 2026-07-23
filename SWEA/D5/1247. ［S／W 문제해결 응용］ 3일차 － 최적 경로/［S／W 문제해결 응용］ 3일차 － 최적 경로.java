import java.io.*;
import java.util.*;

class Solution {
	
	static int N, cr, cc, hr, hc, answer;
	static int[][] customers;
	static boolean[] visited;
	
	static void backtracking(int depth, int r, int c, int len) {
		if (depth == N) {			
			int dist = Math.abs(r - hr) + Math.abs(c - hc);
			answer = Math.min(answer, len + dist);
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			int dist = Math.abs(r - customers[i][0]) + Math.abs(c - customers[i][1]);
			visited[i] = true;
			backtracking(depth + 1, customers[i][0], customers[i][1], len + dist);
			visited[i] = false;
		}
	}
	
	public static void main(String args[]) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			customers = new int[N][2];
			visited = new boolean[N];
			answer = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			cr = Integer.parseInt(st.nextToken());
			cc = Integer.parseInt(st.nextToken());
			hr = Integer.parseInt(st.nextToken());
			hc = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
			}
			
			backtracking(0, cr, cc, 0);
			
			sb.append("#" + t + " " + answer).append('\n');
		}
		
		System.out.println(sb.toString());
    }
}
