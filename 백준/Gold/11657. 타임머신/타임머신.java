import java.io.*;
import java.util.*;

public class Main {

	static final long INF = Long.MAX_VALUE;
	static final int START = 1;

	static int N, M;
	static List<int[]> edges;
	static long[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new long[N + 1];
		Arrays.fill(dist, INF);
		dist[START] = 0;
		
		edges = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges.add(new int[] { a, b, c });
		}
		
		for (int i = 0; i < N - 1; i++) {
			for (int[] edge : edges) {
				int from = edge[0];
				int to = edge[1];
				int cost = edge[2];
				
				if (dist[from] == INF) continue;
				
				if (dist[to] > dist[from] + cost) {
					dist[to] = dist[from] + cost;
				}
			}
		}
		
		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];
			int cost = edge[2];
			
			if (dist[from] == INF) continue;
			
			if (dist[to] > dist[from] + cost) {
				System.out.println(-1);
				return;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			if (dist[i] == INF) sb.append(-1);
			else sb.append(dist[i]);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
