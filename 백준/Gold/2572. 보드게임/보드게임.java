import java.io.*;
import java.util.*;

public class Main {
	
	static final int MIN = Integer.MIN_VALUE;
	static int n, m, k;
	static int[] colors; // 0: R, 1: G, 2: B
	static List<List<int[]>> graph;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	colors = new int[n];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < n; i++) {
    		String c = st.nextToken();
    		if (c.equals("R")) colors[i] = 0;
    		else if (c.equals("G")) colors[i] = 1;
    		else if (c.equals("B")) colors[i] = 2;
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	m = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	graph = new ArrayList<>();
    	for (int i = 0; i <= m; i++) {
    		graph.add(new ArrayList<>());
    	}
    	
    	for (int i = 0; i < k; i++) {
    		st = new StringTokenizer(br.readLine());
    		int v1 = Integer.parseInt(st.nextToken());
    		int v2 = Integer.parseInt(st.nextToken());
    		String c = st.nextToken();
    		
    		if (c.equals("R")) graph.get(v1).add(new int[] { v2, 0 });
    		else if (c.equals("G")) graph.get(v1).add(new int[] { v2, 1 });
    		else if (c.equals("B")) graph.get(v1).add(new int[] { v2, 2 });
    		
    		if (c.equals("R")) graph.get(v2).add(new int[] { v1, 0 });
    		else if (c.equals("G")) graph.get(v2).add(new int[] { v1, 1 });
    		else if (c.equals("B")) graph.get(v2).add(new int[] { v1, 2 });
    	}
    	
    	int[] dp = new int[m + 1];
    	Arrays.fill(dp, MIN);
    	dp[1] = 0;
    	
    	for (int i = 0; i < n; i++) {
    		int[] next = new int[m + 1];
    		Arrays.fill(next, MIN);
    		
    		int c = colors[i];
    		
    		for (int j = 1; j <= m; j++) {
    			if (dp[j] == MIN) continue;
    			
    			for (int[] g : graph.get(j)) {
    				int score = (g[1] == c) ? 1 : 0;
    				next[g[0]] = Math.max(next[g[0]], dp[j] + score);
    			}
    		}
    		
    		dp = next;
    	}
    	
    	int answer = MIN;
    	for (int i = 1; i <= m; i++) answer = Math.max(answer, dp[i]);
    	
    	if (answer < 0) answer = 0;
    	
    	System.out.println(answer * 10);
    }
}
