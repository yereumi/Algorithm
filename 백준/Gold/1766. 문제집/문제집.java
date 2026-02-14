import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static List<List<Integer>> graph;
	static int[] indegree;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		indegree = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			indegree[b]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) pq.offer(i);
		}
		
		List<Integer> result = new ArrayList<>();
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			result.add(cur);
			
			for (int next : graph.get(cur)) {
				indegree[next]--;
				if (indegree[next] == 0) pq.offer(next);
			}
		}
		
		for (int r : result) {
			sb.append(r).append(" ");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
