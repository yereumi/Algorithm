/**
 * 시간 1초: 1억번 안에 연산
 * 최대 메모리 256MB: 
 */
import java.util.*;
import java.io.*;

public class Main {
	
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    static int n, x, y, answer;
    static boolean[] visited;
    static List<List<Integer>> graph;
    
    static void dfs(int node, int cnt) {
    	if (node == y) {
    		answer = cnt;
    		return;
    	}
    	visited[node] = true;
    	for (int n : graph.get(node)) {
    		if (!visited[n]) dfs(n, cnt + 1);
    	}
    }

    public static void main(String[] args) throws Exception {
        n = read();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
        	graph.add(new ArrayList<>());
        }
        x = read();
        y = read();
        int m = read();
        for (int i = 0; i < m; i++) {
        	int a = read();
        	int b = read();
        	graph.get(a).add(b);
        	graph.get(b).add(a);
        }
        visited = new boolean[n + 1];
        answer = 0;
        dfs(x, 0);
        if (answer == 0) answer = -1;
        System.out.println(answer);
    }
}