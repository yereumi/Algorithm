import java.util.*;
import java.io.*;

public class Main {

	static int n, totalCost, vertexCnt;
	static List<List<int[]>> graph;
	static boolean[] visited;
	static PriorityQueue<int[]> pq;
	static List<int[]> newVertex;

	static void mst() {
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int from = cur[0];
			int to = cur[1];
			int cost = cur[2];

			if (visited[to]) continue;

			visited[to] = true;
			totalCost += cost;
			if (cost > 0) {
				newVertex.add(new int[] { from, to });
				vertexCnt++;
			}

			for (int[] next : graph.get(to)) {
				if (!visited[next[1]]) {
					pq.offer(new int[] { to, next[1], next[2] });
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

		visited = new boolean[n + 1];
		pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
		newVertex = new ArrayList<>();
		totalCost = 0;
		vertexCnt = 0;

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int cost = Integer.parseInt(st.nextToken());

				if (cost < 0 && i < j) {
					totalCost += -cost;
					// 이미 설치된 간선은 비용 0으로 PQ에 넣어줌
					graph.get(i).add(new int[] { i, j, 0 });
					graph.get(j).add(new int[] { j, i, 0 });
				} else if (cost > 0) {
					graph.get(i).add(new int[] { i, j, cost });
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				pq.offer(new int[] { i, i, 0 });
				mst();
			}
		}

		System.out.println(totalCost + " " + vertexCnt);
		for (int[] v : newVertex) {
			System.out.println(v[0] + " " + v[1]);
		}
        
        br.close();
	}
}