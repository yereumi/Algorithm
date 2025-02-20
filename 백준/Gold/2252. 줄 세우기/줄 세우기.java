import java.util.*;
import java.io.*;

public class Main {
    
    private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
    
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int n = read();
		int m = read();
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		int[] edgeCount = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int a = read();
			int b = read();
			graph.get(a).add(b);
			edgeCount[b]++;
		}
		
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (edgeCount[i] == 0) dq.offer(i);
		}
		while (!dq.isEmpty()) {
			int v = dq.poll();
			sb.append(v).append(" ");
			for (int u : graph.get(v)) {
				edgeCount[u]--;
				if (edgeCount[u] == 0) dq.offer(u);
			}
		}
		System.out.println(sb);
	}
}
