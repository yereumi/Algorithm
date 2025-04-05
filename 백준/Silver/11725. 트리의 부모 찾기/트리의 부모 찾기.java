import java.util.*;
import java.io.*;

public class Main {
	
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    static int n;
    static int[] parent;
    static List<List<Integer>> graph;
    
    static void dfs(int node) {
    	for (int n : graph.get(node)) {
    		if (parent[n] != -1) continue;
    		parent[n] = node;
    		dfs(n);
    	}
    }

    public static void main(String[] args) throws Exception {
        n = read();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
        	graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
        	int a = read();
        	int b = read();
        	graph.get(a).add(b);
        	graph.get(b).add(a);
        }
        parent = new int[n + 1];
        Arrays.fill(parent, -1);
        dfs(1);
        for (int i = 2; i <= n; i++) {
        	System.out.println(parent[i]);
        }
    }
}