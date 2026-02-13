import java.io.*;
import java.util.*;

public class Main {

	static final int INF = 1_000_000_000;
	static int N, M;
	static int[][] dist;
	static PriorityQueue<int[]> pq; // { 거리, 건물1, 건물2 }
	
	static void select() {
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				calculate(i, j);
			}
		}
	}
	
	static void calculate(int a, int b) {
		int result = 0;
		
		for (int i = 1; i <= N; i++) {
			if (i == a || i == b) continue;
			
			result += Math.min(dist[i][a], dist[i][b]) * 2;
		}
		
		pq.offer(new int[] { result, a, b });
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) dist[i][j] = 0;
				else dist[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dist[a][b] = dist[b][a] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
		    for (int i = 1; i <= N; i++) {
		        for (int j = 1; j <= N; j++) {
		            if (dist[i][k] != INF && dist[k][j] != INF) {
		                dist[i][j] = Math.min(
		                    dist[i][j],
		                    dist[i][k] + dist[k][j]
		                );
		            }
		        }
		    }
		}
		
		pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] != o2[0]) return o1[0] - o2[0];
			if (o1[1] != o2[1]) return o1[1] - o2[1];
			return o1[2] - o2[2];
		});
		
		select();
		int[] answer = pq.poll();
		
		System.out.println(answer[1] + " " + answer[2] + " " + answer[0]);
		
		br.close();
	}
}
