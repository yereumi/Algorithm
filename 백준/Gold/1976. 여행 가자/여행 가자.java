import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] parent;
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA == rootB) return;
		
		parent[rootB] = rootA;
	}
	
	static int find(int x) {
	    if (parent[x] != x) {
	        parent[x] = find(parent[x]);
	    }
	    return parent[x];
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) {
        	parent[i] = i;
        }
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		int connect = Integer.parseInt(st.nextToken());
        		
        		if (connect == 1) {
        			union(i, j);
        		}
        	}
        }
        
        int[] city = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
        	city[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        
        for (int i = 1; i < M; i++) {
        	if (find(city[i - 1]) != find(city[i])) {
        		System.out.println("NO");
        		return;
        	}
        }
        
        System.out.println("YES");
        
        br.close();
    }
}
