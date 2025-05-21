import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n + 1];
		int[] result = new int[n + 1];
		int[] degree = new int[n + 1];
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = result[i] = Integer.parseInt(st.nextToken());
            
			while (true) {
				int node = Integer.parseInt(st.nextToken());
				if (node == -1) break;
				degree[i]++;
				graph.get(node).add(i);
			}
		}
		
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (degree[i] == 0) dq.offer(i);
		}
		
		while (!dq.isEmpty()) {
			int now = dq.poll();
			List<Integer> nodes = graph.get(now);
			
			for (int node : nodes) {
				degree[node]--;
				if (degree[node] == 0) dq.offer(node);
				result[node] = Math.max(result[node], result[now] + time[node]);
			}
		}
		
		for (int i = 1; i <= n; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
	}
}