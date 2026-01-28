import java.io.*;
import java.util.*;

public class Main {
	
	static final long INF = Long.MAX_VALUE;
	
	static int N, M, X;
	static List<List<int[]>> graph;
	
	static long[] dijkstra(int start) {
		long[] dist = new long[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[] { start, 0 });
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int curNode = cur[0];
			int curDist = cur[1];
			
			if (dist[curNode] < curDist) continue;
			
			for (int[] next : graph.get(curNode)) {
				int nextNode = next[0];
				int nextDist = next[1] + curDist;
				
				if (dist[nextNode] > nextDist) {
					dist[nextNode] = nextDist;
					pq.offer(new int[] { nextNode, nextDist });
				}
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(new int[] { end, time });
		}
		
		long[] depart = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			long[] dist = dijkstra(i);
			depart[i] = dist[X];
		}
		
		long[] arrive = dijkstra(X);
		long[] result = new long[N + 1];
		
		long answer = 0;
		for (int i = 1; i <= N; i++) {
			result[i] = depart[i] + arrive[i];
			answer = Math.max(answer, result[i]);
		}
		
		System.out.println(answer);
		br.close();
	}
}
