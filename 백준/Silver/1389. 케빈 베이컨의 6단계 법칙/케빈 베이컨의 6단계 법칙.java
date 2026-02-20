import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int N, M;
	static int[][] dist;
	
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
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        int minIdx = 0;
        int min = INF;
        for (int i = 1; i <= N; i++) {
        	int total = 0;
        	for (int j = 1; j <= N; j++) {
        		total += dist[i][j];
        	}
        	if (total < min) {
        		min = total;
        		minIdx = i;
        	}
        }
        
        System.out.println(minIdx);
    }
}
