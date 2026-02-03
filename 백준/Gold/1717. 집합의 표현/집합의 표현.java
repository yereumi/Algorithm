import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
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
        StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
        	parent[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int op = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if (op == 0) {
        		union(a, b);
        	} else {
        		sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
        	}
        }
        
        System.out.println(sb.toString());
        
        br.close();
    }
}
