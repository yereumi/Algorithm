import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new int[] { b, c });
			graph.get(b).add(new int[] { a, c });
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] { 1, 0 });
		boolean[] visited = new boolean[n + 1];
		int weightSum = 0;
		int maxWeight = 0;
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int u = now[0];
			int w = now[1];

			if (visited[u])
				continue;
			weightSum += w;
			if (w > maxWeight) maxWeight = w;
			visited[u] = true;
			for (int[] next : graph.get(u)) {
				int nu = next[0];
				int nw = next[1];
				pq.add(new int[] { nu, nw });
			}
		}
		bw.write(String.valueOf(weightSum - maxWeight));
		bw.flush();
		br.close();
		bw.close();
	}
}
