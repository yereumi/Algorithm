import java.io.*;
import java.util.*;

public class Main {

	static final int INF = 1_000_000_000;
	static int N, M, S, D;

	static List<List<int[]>> graph;
	static List<List<int[]>> reverseGraph;
	static int[] dist;

	static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		dist = new int[N];
		Arrays.fill(dist, INF);
		pq.offer(new int[] { S, 0 });
		dist[S] = 0;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curNode = cur[0], curDist = cur[1];

			if (curDist > dist[curNode]) continue;

			for (int[] next : graph.get(curNode)) {
				int nextNode = next[0];
				int nextDist = curDist + next[1];

				if (nextDist < dist[nextNode]) {
					dist[nextNode] = nextDist;
					pq.offer(new int[] { nextNode, nextDist });
				}
			}
		}
	}

	static void removeShortestPath() {
		Deque<Integer> dq = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		dq.offer(D);

		while (!dq.isEmpty()) {
			int cur = dq.poll();

			if (visited[cur]) continue;
			visited[cur] = true;

			for (int[] prev : reverseGraph.get(cur)) {
				int prevNode = prev[0];
				int weight = prev[1];

				if (dist[prevNode] + weight == dist[cur]) {
					Iterator<int[]> it = graph.get(prevNode).iterator();
					while (it.hasNext()) {
						int[] edge = it.next();
						if (edge[0] == cur && edge[1] == weight) {
							it.remove();
						}
					}

					dq.offer(prevNode);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0) break;

			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());

			graph = new ArrayList<>();
			reverseGraph = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				graph.add(new ArrayList<>());
				reverseGraph.add(new ArrayList<>());
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int U = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());

				graph.get(U).add(new int[] { V, P });
				reverseGraph.get(V).add(new int[] { U, P });
			}

			dijkstra();
			removeShortestPath();
			dijkstra();

			sb.append(dist[D] == INF ? -1 : dist[D]).append("\n");
		}

		System.out.println(sb.toString());
	}
}
