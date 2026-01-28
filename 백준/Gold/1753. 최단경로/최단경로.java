import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	
	static int V, E, K;
	static List<List<int[]>> graph;
	static int[] dist;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new int[] { v, w });
		}
		
		dist = new int[V + 1];
		Arrays.fill(dist, INF);
		dist[K] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[] { K, 0 });
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int curNode = cur[0];
			int curDist = cur[1];
			
			if (curDist > dist[curNode]) continue;
			
			for (int[] next : graph.get(curNode)) {
				int nextNode = next[0];
				int nextDist = next[1] + curDist;
				
				if (dist[nextNode] > nextDist) {
					dist[nextNode] = nextDist;
					pq.offer(new int[] { nextNode, nextDist });
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) sb.append("INF");
			else sb.append(dist[i]);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
