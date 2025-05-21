import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] time = new int[n + 1];
			int[] degree = new int[n + 1];
			int[] result = new int[n + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				time[i] = result[i] = Integer.parseInt(st.nextToken());
			}
			
			List<List<Integer>> graph = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				graph.get(x).add(y);
				degree[y]++;
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
			
			int w = Integer.parseInt(br.readLine());
			sb.append(result[w]).append("\n");
		}
		System.out.println(sb);
	}
}