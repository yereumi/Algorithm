import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, w;
	
	static boolean shortestPath(int[][] edges) {
		long[] dist = new long[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		
		for (int i = 0; i < n - 1; i++) {
			for (int[] e : edges) {
				int s = e[0];
				int d = e[1];
				int w = e[2];
				
				if (dist[s] != Long.MAX_VALUE && dist[s] + w < dist[d]) {
					dist[d] = dist[s] + w;
				}
			}
		}
		
		for (int[] e : edges) {
			int s = e[0];
			int d = e[1];
			int w = e[2];
			
			if (dist[s] != Long.MAX_VALUE && dist[s] + w < dist[d]) {
				return true;
			}
		}
		
		if (dist[1] < 0) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			int[][] edges = new int[m * 2 + w][3];
			int idx = 0;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				edges[idx][0] = s;
				edges[idx][1] = e;
				edges[idx++][2] = t;
				edges[idx][0] = e;
				edges[idx][1] = s;
				edges[idx++][2] = t;
			}
			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				edges[idx][0] = Integer.parseInt(st.nextToken());
				edges[idx][1] = Integer.parseInt(st.nextToken());
				edges[idx++][2] = Integer.parseInt(st.nextToken()) * -1;
			}
			
			if (shortestPath(edges)) {
				sb.append("YES");
			} else {
				sb.append("NO");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
