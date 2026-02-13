import java.io.*;
import java.util.*;

public class Main {

	static final int INF = 1_000_000_000;
	static int V, E;
	static int[][] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dist = new int[V + 1][V + 1];
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j) dist[i][j] = 0;
				else dist[i][j] = INF;
			}
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dist[a][b] = c;
		}
		
		for (int k = 1; k <= V; k++) {
		    for (int i = 1; i <= V; i++) {
		        for (int j = 1; j <= V; j++) {
		            if (dist[i][k] != INF && dist[k][j] != INF) {
		                dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
		            }
		        }
		    }
		}
		
		int answer = INF;
		for (int i = 1; i <= V; i++) {
			for (int j = i + 1; j <= V; j++) {
				if (i != j && dist[i][j] != INF && dist[j][i] != INF) {
                    answer = Math.min(answer, dist[i][j] + dist[j][i]);
                }
			}
		}
		
		System.out.println(answer == INF ? -1 : answer);
		
		br.close();
	}
}
