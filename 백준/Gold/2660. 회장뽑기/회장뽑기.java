import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static List<List<Integer>> graph = new ArrayList<>();
	
	static int bfs(int p) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, -1);
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { p, 0 });
		dist[p] = 0;
		
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			
			for (int m : graph.get(cur[0])) {
				if (dist[m] != -1) continue;
				
				dist[m] = cur[1] + 1;
				dq.offer(new int[] { m, dist[m] });
			}
		}
		
		int max = -1;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, dist[i]);
		}
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			
			if (p1 == -1) break;
			
			graph.get(p1).add(p2);
			graph.get(p2).add(p1);
		}
		
		int[] dist = new int[n + 1];
		dist[0] = 100;
		for (int i = 1; i <= n; i++) {
			dist[i] = bfs(i);
		}
		
		int result = 100;
		for (int i = 1; i <= n; i++) {
			result = Math.min(result, dist[i]);
		}
		
		int resultCnt = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (dist[i] == result) {
				resultCnt++;
				list.add(i);
			}
		}
        
		Collections.sort(list);
		sb.append(result + " " + resultCnt).append("\n");
		for (int i : list) sb.append(i).append(" ");
		
		System.out.println(sb.toString());
		br.close();
	}
}
