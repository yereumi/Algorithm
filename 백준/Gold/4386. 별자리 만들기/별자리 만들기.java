import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] parent;
	static double[][] stars;
	static List<double[]> graph;

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
		N = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		stars = new double[N + 1][2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			stars[i][0] = Double.parseDouble(st.nextToken());
			stars[i][1] = Double.parseDouble(st.nextToken());
		}
		
		graph = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				double dist = Math.sqrt(Math.pow((stars[i][0] - stars[j][0]), 2) + Math.pow((stars[i][1] - stars[j][1]), 2));
				graph.add(new double[] { i, j, dist });
			}
		}
		
		Collections.sort(graph, (o1, o2) -> Double.compare(o1[2], o2[2]));
		double cost = 0;
		int cnt = 0;
		for (int i = 0; i < N * (N - 1); i++) {
			if (cnt == N - 1) break;
			double[] cur = graph.get(i);
			
			if (find((int)cur[0]) != find((int)cur[1])) {
				union((int)cur[0], (int)cur[1]);
				cost += cur[2];
				cnt++;
			}
		}
		
		System.out.println(cost);
		
		br.close();
	}
}
