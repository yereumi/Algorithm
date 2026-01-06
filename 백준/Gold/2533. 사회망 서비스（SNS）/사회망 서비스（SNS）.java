import java.io.*;
import java.util.*;

public class Main {
	
	static int n, answer;
	static List<List<Integer>> graph;
	static boolean[] visited;
	
	static final int ROOT = 1;
	
	static boolean dp(int v) {
		boolean flag = false;
		for (int g : graph.get(v)) {
			if (visited[g]) continue;
			visited[g] = true;
			
			if (!dp(g)) flag = true;
		}
		
		if (flag) {
			answer++;
			return true;
		}
		
		return false;
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
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	graph.get(u).add(v);
        	graph.get(v).add(u);
        }
        
        visited = new boolean[n + 1];
        visited[ROOT] = true;
        answer = 0;
        dp(ROOT);
        
        System.out.println(answer);
    }
}
