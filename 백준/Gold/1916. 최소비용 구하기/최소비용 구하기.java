import java.io.*;
import java.util.*;

public class Main {
	
	static final long INF = Long.MAX_VALUE;
	
	static int N, M;
	static List<List<int[]>> graph;
	static long[] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(new int[] { end, cost });
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dist = new long[N + 1];
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
		
		System.out.println(dist[end]);
		br.close();
	}
}
