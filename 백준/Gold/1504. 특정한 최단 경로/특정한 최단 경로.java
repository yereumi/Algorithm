import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int N, E, v1, v2;
	static List<List<long[]>> graph;
	
	static long[] dijkstra(int start) {
		PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[1], b[1]));
		long[] dist = new long[N + 1];
		Arrays.fill(dist, INF);
		pq.offer(new long[] { start, 0 });
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			long[] cur = pq.poll();
			int curNode = (int)cur[0];
			long curDist = cur[1];
			
			if (curDist > dist[curNode]) continue;
			
			for (long[] next : graph.get(curNode)) {
				int nextNode = (int)next[0];
				long nextDist = curDist + next[1];
				
				if (nextDist < dist[nextNode]) {
					dist[nextNode] = nextDist;
					pq.offer(new long[] { nextNode, nextDist });
				}
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			graph.get(a).add(new long[] { b, c });
			graph.get(b).add(new long[] { a, c });
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		long[] dist1 = dijkstra(1);
		long[] distV1 = dijkstra(v1);
		long[] distV2 = dijkstra(v2);
		long answer = INF;
		
		answer = Math.min(answer, Math.min(dist1[v2] + distV2[v1] + distV1[N], dist1[v1] + distV1[v2] + distV2[N]));
		
		System.out.println(answer == INF ? -1 : answer);
	}
}
