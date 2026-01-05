import java.io.*;
import java.util.*;

public class Main {
	
	static final int ROOT = 1;
	static int n, m;
	static List<List<int[]>> tree;
	static boolean[] visited;
	
	static int destroy(int v, int d) {		
		if (v != ROOT && tree.get(v).size() == 1) {
			visited[v] = true;
			return d;
		}

		int result = 0;
		for (int[] t : tree.get(v)) {
            int nextV = t[0];
            int nextD = t[1];
            
			if (visited[nextV]) continue;
			visited[nextV] = true;
			
			result += destroy(nextV, nextD);
		}
		
		return result < d ? result : d;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        while (t-- > 0) {
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	
        	tree = new ArrayList<>();
        	for (int i = 0; i <= n; i++) {
        		tree.add(new ArrayList<>());
        	}
        	
        	for (int i = 0; i < m; i++) {
            	st = new StringTokenizer(br.readLine());
            	int v1 = Integer.parseInt(st.nextToken());
        		int v2 = Integer.parseInt(st.nextToken());
        		int d = Integer.parseInt(st.nextToken());
        		
        		tree.get(v1).add(new int[] { v2, d });
        		tree.get(v2).add(new int[] { v1, d });
        	}
        	
        	visited = new boolean[n + 1];
        	visited[ROOT] = true;
        	sb.append(destroy(ROOT, Integer.MAX_VALUE)).append("\n");
        }
        
        System.out.println(sb);
    }
}
