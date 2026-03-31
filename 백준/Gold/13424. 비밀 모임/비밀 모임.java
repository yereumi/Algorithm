import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = 1_000_000_000;
	static int N, M, K;
	static List<List<int[]>> graph;
	static List<Integer> friends;
	
	static int floyd() {
		int[][] dist = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int[] next : graph.get(i)) {
				dist[i][next[0]] = next[1];
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (dist[j][i] + dist[i][k] < dist[j][k]) {
						dist[j][k] = dist[j][i] + dist[i][k];
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
			
			sb.append(floyd()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
