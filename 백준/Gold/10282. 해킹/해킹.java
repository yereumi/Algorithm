import java.io.*;
import java.util.*;

public class Main {
	
	static long INF = Long.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			List<List<int[]>> computers = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				computers.add(new ArrayList<>());
			}
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				computers.get(b).add(new int[] { a, s });
			}
			
			long[] dist = new long[n + 1];
			Arrays.fill(dist, INF);
			
			Deque<int[]> dq = new ArrayDeque<>();
			dq.offer(new int[] { c, 0 });
			dist[c] = 0;
			while (!dq.isEmpty()) {
				int[] cur = dq.poll();
				int curComputer = cur[0];
				int curTime = cur[1];
				
				for (int[] next : computers.get(curComputer)) {
					int nextComputer = next[0];
					int nextTime = next[1] + curTime;
					
					if (dist[nextComputer] > nextTime) {
						dist[nextComputer] = nextTime;
						dq.offer(new int[] { nextComputer, nextTime });
					}
				}
			}
			
			int cnt = 0;
			long max = 0;
			for (int i = 1; i <= n; i++) {
				if (dist[i] != INF) {
					cnt++;
					max = Math.max(max, dist[i]);
				}
			}
			
			sb.append(cnt + " " + max).append("\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}
