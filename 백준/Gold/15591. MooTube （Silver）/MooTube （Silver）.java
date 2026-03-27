import java.io.*;
import java.util.*;

public class Main {
	
	static int N, Q;
	static List<List<long[]>> graph;
	
	static int recommend(long k, int v) {
		int answer = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(v);
		boolean[] visited = new boolean[N + 1];
		visited[v] = true;
		
		while (!dq.isEmpty()) {
			int cur = dq.poll();
			
			for (long[] next : graph.get(cur)) {
				if (visited[(int)next[0]]) continue;
				if (next[1] >= k) {
					dq.offer((int)next[0]);
					visited[(int)next[0]] = true;
					answer++;
				}
			}
		}
		
		return answer;
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			
			graph.get(p).add(new long[] { q, r });
			graph.get(q).add(new long[] { p, r });
		}
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			long k = Long.parseLong(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			sb.append(recommend(k, v)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
