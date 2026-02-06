import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
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
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		graph = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.add(new int[] { a, b, c });
		}
		
		Collections.sort(graph, (o1, o2) -> o1[2] - o2[2]);
		int cost = 0;
		int cnt = 0;
		for (int i = 0; i < M; i++) {			
			int[] cur = graph.get(i);
			
			if (find(cur[0]) != find(cur[1])) {
				union(cur[0], cur[1]);
				cost += cur[2];
				cnt++;
				
				if (cnt == N - 1) break;
			}
		}
		
		System.out.println(cost);
		
		br.close();
	}
}
