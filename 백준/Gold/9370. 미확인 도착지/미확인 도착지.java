import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int n, m, t, s, g, h;
	static List<List<int[]>> graph;
	static List<Integer> destinations;
	static List<List<Integer>> path;
	
	static int[] dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
		int[] dist = new int[n + 1];
		Arrays.fill(dist, 1_000_000_000);
		pq.offer(new int[] { start, 0 });
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curNode = cur[0];
			
			for (int[] next : graph.get(curNode)) {
				int nextNode = next[0], nextDist = next[1];
				
				if (dist[curNode] + nextDist < dist[nextNode]) {
					dist[nextNode] = dist[curNode] + nextDist;
					pq.offer(new int[] { nextNode, dist[nextNode] });
				}
			}
		}		
		
		return dist;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			path = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
				path.add(new ArrayList<>());
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				graph.get(a).add(new int[] { b, d });
				graph.get(b).add(new int[] { a, d });
			}
			
			destinations = new ArrayList<>();
			int[] distS = dijkstra(s);
			int[] distG = dijkstra(g);
			int[] distH = dijkstra(h);
			
			for (int i = 0; i < t; i++) {
				int x = Integer.parseInt(br.readLine());
				if (distS[x] == distS[g] + distG[h] + distH[x]
						 || distS[x] == distS[h] + distH[g] + distG[x]) destinations.add(x);
			}
			
			Collections.sort(destinations);
			
			for (int d : destinations) {
				sb.append(d + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
