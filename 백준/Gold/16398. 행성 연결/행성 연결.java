import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static List<List<int[]>> planets;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		planets = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			planets.add(new ArrayList<>());
		}
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int c = Integer.parseInt(st.nextToken());
				planets.get(i).add(new int[] { j, c });
				planets.get(j).add(new int[] { i, c });
			}
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[] { 1, 0 });
		boolean[] visited = new boolean[N + 1];

		long totalCost = 0;
		int cnt = 0;
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int v = cur[0];
			int cost = cur[1];
			
			if (visited[v]) continue;
			
			visited[v] = true;
			totalCost += cost;
			cnt++;
			
			if (cnt == N) break;
			
			for (int[] next : planets.get(v)) {
				int nextV = next[0];
				int nextCost = next[1];
				
				if (!visited[nextV]) pq.offer(new int[] { nextV, nextCost });
			}
		}
		
		System.out.println(totalCost);
		
		br.close();
	}
}
