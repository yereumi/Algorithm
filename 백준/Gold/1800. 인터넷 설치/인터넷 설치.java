import java.io.*;
import java.util.*;

public class Main {
	
	static int N, P, K;
	static List<List<int[]>> graph;
	
	static boolean find(int x) {
	    Deque<Integer> dq = new ArrayDeque<>();
	    int[] dist = new int[N + 1];
	    Arrays.fill(dist, Integer.MAX_VALUE);

	    dq.offer(1);
	    dist[1] = 0;

	    while (!dq.isEmpty()) {
	        int cur = dq.poll();

	        for (int[] next : graph.get(cur)) {
	            int nextNode = next[0];
	            int cost = (next[1] > x) ? 1 : 0;

	            if (dist[nextNode] > dist[cur] + cost) {
	                dist[nextNode] = dist[cur] + cost;

	                if (cost == 0) dq.offerFirst(nextNode);
	                else dq.offerLast(nextNode);
	            }
	        }
	    }

	    return dist[N] <= K;
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new int[] { b, c });
			graph.get(b).add(new int[] { a, c });
		}
		
		int l = 0, r = 1_000_000;
		int answer = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			
			if (find(mid)) {
				answer = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		System.out.println(answer);
	}
}
