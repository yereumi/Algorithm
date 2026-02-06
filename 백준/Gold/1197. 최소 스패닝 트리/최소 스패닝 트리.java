import java.io.*;
import java.util.*;

public class Main {
	
	static int V, E;
	static int[] parent;
	static List<int[]> graph;

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]); // 경로 압축
		}
		return parent[x];
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) return;

		parent[rootB] = rootA;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parent = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			parent[i] = i;
		}
		
		graph = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.add(new int[] { a, b, c });
		}
		
		Collections.sort(graph, (o1, o2) -> o1[2] - o2[2]);
		int cost = 0;
		int cnt = 0;
		for (int i = 0; i < E; i++) {			
			int[] cur = graph.get(i);
			
			if (find(cur[0]) != find(cur[1])) {
				union(cur[0], cur[1]);
				cost += cur[2];
				cnt++;
				
				if (cnt == V - 1) break;
			}
		}
		
		System.out.println(cost);
		
		br.close();
	}
}
