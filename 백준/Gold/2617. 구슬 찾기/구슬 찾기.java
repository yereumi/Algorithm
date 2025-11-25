import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
    static List<List<Integer>> heavy, light;
    
    static int bfs(int start, List<List<Integer>> graph) {
    	boolean[] visited = new boolean[n + 1];
    	Deque<Integer> dq = new ArrayDeque<>();
    	visited[start] = true;
    	dq.offer(start);
    	
    	int cnt = 0;
    	
    	while (!dq.isEmpty()) {
    		int now = dq.poll();
    		for (int next : graph.get(now)) {
    			if (!visited[next]) {
    				visited[next] = true;
    				dq.offer(next);
    				cnt++;
    			}
    		}
    	}
    	
    	return cnt;
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		heavy = new ArrayList<>();
        light = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            heavy.add(new ArrayList<>());
            light.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int h = Integer.parseInt(st.nextToken());
        	int l = Integer.parseInt(st.nextToken());
        	light.get(h).add(l);
        	heavy.get(l).add(h);
        }
        
        int mid = (n + 1) / 2;
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
        	int heavyCnt = bfs(i, heavy);
        	int lightCnt = bfs(i, light);
        	
        	if (heavyCnt >= mid || lightCnt >= mid) {
        		answer++;
        	}
        }
		
		
		System.out.println(answer);
	}
}
