import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] edges;
	static long[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		edges = new int[m][3];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dist = new long[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		
		for (int i = 0; i < n - 1; i++) {
			for (int[] e : edges) {
				int s = e[0];
				int d = e[1];
				int w = e[2];
				
				if (dist[s] != Integer.MAX_VALUE && dist[s] + w < dist[d]) {
					dist[d] = dist[s] + w;
				}
			}
		}
		
		// 음수 간선 사이클 확인
		for (int[] e : edges) {
			int s = e[0];
			int d = e[1];
			int w = e[2];
			
			if (dist[s] != Integer.MAX_VALUE && dist[s] + w < dist[d]) {
				System.out.println(-1);
				return;
			}
		}

		StringBuilder sb = new StringBuilder();
		
		for (int i = 2; i <= n; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append(-1).append("\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
