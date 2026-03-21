import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, A, B;
	static List<List<long[]>> graph;
	static List<List<Integer>> list;
	static List<Integer> result;
	static boolean[] visited;
	static long[] dist;
	
	static void dijkstra() {
		dist = new long[N + 1];
    	for(int i = 0; i <= N; i++) {
    		dist[i] = Long.MAX_VALUE;
    	}
    	dist[A] = 0;
    	
		PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[1] != o2[1]) return Long.compare(o1[1], o2[1]);
			return Long.compare(o1[0], o2[0]);
		});
		
		pq.offer(new long[] { A, 0 });
		while (!pq.isEmpty()) {
			long[] cur = pq.poll();
			
			if (dist[(int)cur[0]] < cur[1]) continue;
			
			for (long[] next : graph.get((int)cur[0])) {
				int nextNode = (int)next[0];
				long nextDist = next[1] + cur[1];
				
				if (dist[nextNode] > nextDist) {
					dist[nextNode] = nextDist;
					pq.offer(new long[] { nextNode, nextDist });
					list.get(nextNode).clear();
					list.get(nextNode).add((int)cur[0]);
				} else if (dist[nextNode] == nextDist) {
					list.get(nextNode).add((int)cur[0]);
				}
			}
		}
	}
	
	static void dfs(int node) {
		for (int i : list.get(node)) {
			if (visited[i]) continue;
			visited[i] = true;
			result.add(i);
			dfs(i);
		}
	}
	
    public static void main(String[] args) throws Exception {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	A = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	
    	graph = new ArrayList<>();
    	for (int i = 0; i <= N; i++) {
    		graph.add(new ArrayList<>());
    	}
    	
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		long c = Long.parseLong(st.nextToken());
    		
    		graph.get(a).add(new long[] { b, c });
    		graph.get(b).add(new long[] { a, c });
    	}
    	
    	list = new ArrayList<>();
    	for (int i = 0; i <= N; i++) {
    		list.add(new ArrayList<>());
    	}
    
    	dijkstra();
    	list.get(B).add(B);
    	
    	result = new ArrayList<>();
    	result.add(B);
    	visited = new boolean[N + 1];
    	visited[B] = true;
    	dfs(B);
    	
    	sb.append(result.size()).append("\n");
    	Collections.sort(result);
    	for (int i : result) sb.append(i + " ");
    	
    	System.out.println(sb.toString());
    }
}
