import java.io.*;
import java.util.*;

public class Main {
	
	static final long INF = Integer.MAX_VALUE; 
	static int V, E, M, S, x, y;
	static List<List<int[]>> graph;
	static List<Integer> mac, star;
	
	static long[] dijkstra(List<Integer> num) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		long[] dist = new long[V + 1];
		Arrays.fill(dist, INF);
		
		for (int i : num) {
			pq.offer(new int[] { i, 0 });
			dist[i] = 0;
		}
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curNode = cur[0], curDist = cur[1];
			
			if (dist[curNode] < curDist) continue;
			
			for (int[] next : graph.get(curNode)) {
				int nextNode = next[0], nextDist = next[1] + curDist;
				
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
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
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
			graph.get(v).add(new int[] { u, w });
		}
	
		mac = new ArrayList<>();
		star = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			mac.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());	
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++) {
			star.add(Integer.parseInt(st.nextToken()));
		}
		
		long[] distMac = dijkstra(mac);
		long[] distStar = dijkstra(star);
		
		long dist = INF;
		int answer = -1;
		for (int i = 0; i <= V; i++) {
			if (distMac[i] != 0 && distStar[i] != 0 && distMac[i] <= x && distStar[i] <= y) {
				if (distMac[i] + distStar[i] < dist) {
					dist = distMac[i] + distStar[i];
					answer = i;
				}
			}
		}
		
		System.out.println(answer == -1 ? -1 : dist);
	}
}
