import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parent;

	static int find(int x) {
	    if (parent[x] == x) return x;
	    return parent[x] = find(parent[x]);
	}

	static boolean union(int x, int y) {
	    int parentX = find(x);
	    int parentY = find(y);

	    if (parentX == parentY) return false;

	    parent[parentY] = parentX;
	    return true;
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++) {
    			int c = Integer.parseInt(st.nextToken());
    			if (i < j) {
    				pq.offer(new int[] { i, j, c });
    			}
    		}
    	}
    	
    	parent = new int[N];
    	for (int i = 0; i < N; i++) {
    		parent[i] = i;
    	}
    	
    	long cost = 0;
    	while (!pq.isEmpty()) {
    		int[] cur = pq.poll();
    		
    		int v1 = cur[0];
    		int v2 = cur[1];
    		int c = cur[2];
    		
    		if (find(v1) == find(v2)) continue;
    		
    		union(v1, v2);
    		cost += c;
    	}
    	
    	System.out.println(cost);
    }
}
