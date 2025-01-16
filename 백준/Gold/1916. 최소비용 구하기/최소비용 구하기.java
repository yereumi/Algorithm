import java.util.*;
import java.io.*;

public class Main {
	
	static int n, start, end, minCost = Integer.MAX_VALUE;
	static int[] distance;
	static List<List<int[]>> graph;
	static PriorityQueue<int[]> pq;
	
	public static void dijkstra() {
		distance = new int[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] { start, 0 });
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int current = now[0];
			int currentDistance = now[1];
			
			if (distance[current] < currentDistance) continue;
			
			for (int[] edge : graph.get(current)) {
				int next = edge[1];
				int nextDistance = edge[2];
				if (distance[current] + nextDistance < distance[next]) {
					distance[next] = distance[current] + nextDistance;
					pq.add(new int[] { next, nextDistance });
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			graph.get(v1).add(new int[] { v1, v2, d });
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra();
		
		System.out.println(distance[end]);
	}
}
