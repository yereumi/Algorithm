import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n + m; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i <= m; i++) {
			int tubeNode = n + i;

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				int station = Integer.parseInt(st.nextToken());

				graph.get(station).add(tubeNode);
				graph.get(tubeNode).add(station);
			}
		}

		Deque<Integer> dq = new ArrayDeque<>();
		boolean[] visited = new boolean[n + m + 1];
		int[] dist = new int[n + 1];
		dq.offer(1);
		visited[1] = true;
		dist[1] = 1;
		
		while (!dq.isEmpty()) {
			int now = dq.poll();
			
			for (int g : graph.get(now)) {
				if (g <= n) { // 역일 때
					if (visited[g]) continue;
					visited[g] = true;
					for (int tube : graph.get(g)) {
						if (visited[tube]) continue;
						dq.offer(tube);
						visited[tube] = true;
					}
				}
				else { // 큐브일 때
					if (visited[g]) continue;
					visited[g] = true;
					for (int station : graph.get(g)) {
						if (visited[station]) continue;
						dq.offer(station);
						visited[station] = true;
						dist[station] = dist[now] + 1;
					}
				}
			}
		}
		
		System.out.println(dist[n] == 0 ? -1 : dist[n]);
	}
}
