import java.io.*;
import java.util.*;

public class Main {
	
	public static final int INF = 1_000_000_000;
	public static int n, m, r;
	public static int[] items;
	public static int[][] dist;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		items = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		dist = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dist[i], INF);
		}
		
		for (int i = 1; i <= n; i++) {
			dist[i][i] = 0;
		}
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			dist[a][b] = l;
			dist[b][a] = l;
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dist[i][k] == INF || dist[k][j] == INF) continue;
					
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
				}
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] <= m) cnt += items[j];
			}
			
			answer = Math.max(answer, cnt);
		}
		
		System.out.println(answer);
	}
}
