import java.io.*;
import java.util.*;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static int N, M;
	static int[][] dist;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		dist = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) dist[i][j] = 0;
				else dist[i][j] = INF;
			}
		}
		
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dist[a][b] = Math.min(dist[a][b], c);
		}
		
		for (int k = 1; k <= N; k++) {
		    for (int i = 1; i <= N; i++) {
		        for (int j = 1; j <= N; j++) {
		            if (dist[i][k] != INF && dist[k][j] != INF) {
		                dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
		            }
		        }
		    }
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j =1; j <= N; j++) {
				sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}
