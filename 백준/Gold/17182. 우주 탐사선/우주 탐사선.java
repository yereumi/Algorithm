import java.util.*;
import java.io.*;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int N, K;
	static int[][] board;
	static int[][] dist;
	static int answer;
	
	static void backtracking(int v, int visited, int d) {
		if (visited == (1 << N) - 1) {
	        answer = Math.min(answer, d);
	        return;
	    }

	    for (int i = 0; i < N; i++) {
	        if (i != v && (visited & (1 << i)) == 0) {
	            backtracking(i, visited | (1 << i), d + dist[v][i]);
	        }
	    }
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = board[i][j];
            }
        }
        
        for (int k = 0; k < N; k++) {
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
        		}
        	}
        }
        
        answer = Integer.MAX_VALUE;
        backtracking(K, 1 << K, 0);
        System.out.println(answer);
    }
}
