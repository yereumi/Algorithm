import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static List<List<int[]>> graph;
	static boolean[] visited;
	
	static final int ROOT = 1;
	
	static long cut(int v, long d) {
		int cnt = graph.get(v).size();
		if (v != ROOT && cnt == 1) return d;
		
		long answer = 0;
		for (int[] g : graph.get(v)) {
			int nextV = g[0];
			int nextD = g[1];
			
			if (visited[nextV]) continue;
			visited[nextV] = true;
			answer += cut(nextV, nextD); 
		}
		
		return answer < d ? answer : d;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
        	graph.add(new ArrayList<>());
        }
        
    	StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	graph.get(a).add(new int[] { b, v });
        	graph.get(b).add(new int[] { a, v });
        }
        
        visited = new boolean[n + 1];
        visited[ROOT] = true;
        System.out.println(cut(ROOT, Long.MAX_VALUE));
    }
}
