import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static List<List<int[]>> graph;
	
	static int bfs(int start, int end) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { start, 0 });
		boolean[] visited = new boolean[n + 1];
		visited[start] = true;
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			
			if (now[0] == end) {
				return now[1];
			}
			for (int[] next : graph.get(now[0])) {
				if (!visited[next[0]]) {
					dq.offer(new int[] { next[0], now[1] + next[1] });
					visited[next[0]] = true;
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < n - 1; i ++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(new int[] { v2, d });
			graph.get(v2).add(new int[] { v1, d });
		}
		
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int v1 = Integer.parseInt(st.nextToken());
        	int v2 = Integer.parseInt(st.nextToken());
        	
        	sb.append(bfs(v1, v2)).append("\n");
        }
        
        System.out.println(sb);
    }
}