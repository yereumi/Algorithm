import java.util.*;
import java.io.*;

public class Main {

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
	static int edgeCount;
	static List<List<Integer>> graph;
	static boolean[] visited;
	
	static void mst(int startVertex) {
		for (int v : graph.get(startVertex)) {
			if (!visited[v]) {
				visited[v] = true;
				mst(v);
				edgeCount++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int t = read();
		while (t-- > 0) {
			int n = read();
			int m = read();
			graph = new ArrayList<>();
			for (int i = 0; i < n + 1; i++) {
				graph.add(new ArrayList<>());
			}
			for (int i = 0; i < m; i++) {
				int v1 = read();
				int v2 = read();
				graph.get(v1).add(v2);
				graph.get(v2).add(v1);
			}
			edgeCount = -1;
			visited = new boolean[n + 1];
			mst(1);
			sb.append(edgeCount).append("\n");
		}
		System.out.println(sb);
	}
}
