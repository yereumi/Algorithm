import java.io.*;
import java.util.*;

public class Main {

	static final long INF = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			List<int[]> edges = new ArrayList<>();
			long[] dist = new long[N + 1];
			Arrays.fill(dist, INF);
			dist[0] = 0;
			
            // 슈퍼 소스
			for (int i = 1; i <= N; i++) {
			    edges.add(new int[] { 0, i, 0 });
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				edges.add(new int[] { s, e, t });
				edges.add(new int[] { e, s, t });
			}
			
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				edges.add(new int[] { s, e, -1 * t });
			}
			
			for (int i = 0; i < N - 1; i++) {
				for (int[] edge : edges) {
					int from = edge[0];
					int to = edge[1];
					int cost = edge[2];
					
					if (dist[to] > dist[from] + cost) {
						dist[to] = dist[from] + cost;
					}
				}
			}
			
			boolean flag = false;
			
			for (int[] edge : edges) {
				int from = edge[0];
				int to = edge[1];
				int cost = edge[2];
				
				if (dist[to] > dist[from] + cost) {
					flag = true;
					break;
				}
			}
			
			sb.append(flag ? "YES" : "NO").append('\n');
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
