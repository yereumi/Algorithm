import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K;
	static List<List<int[]>> graph;
	static List<Integer> friends;
	
	static int dijkstra() {
		int[][] dist = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		for (int i = 1; i <= N; i++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
			pq.offer(i);
			dist[i][i] = 0;
			
			while (!pq.isEmpty()) {
				int cur = pq.poll();
				
				for (int[] next : graph.get(cur)) {
					int nextNode = next[0], nextDist = next[1];
					
					if (dist[i][cur] + nextDist < dist[i][nextNode]) {
						dist[i][nextNode] = dist[i][cur] + nextDist;
						pq.offer(nextNode);
					}
				}
			}
		}
		
		int answer = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int f : friends) {
				sum += dist[i][f];
			}
			
			if (sum < min) {
				min = sum;
				answer = i;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				graph.get(a).add(new int[] { b, c });
				graph.get(b).add(new int[] { a, c });
			}
			
			friends = new ArrayList<>();
			K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				friends.add(Integer.parseInt(st.nextToken()));
			}
			
			sb.append(dijkstra()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
