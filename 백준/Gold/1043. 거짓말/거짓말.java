import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[] parent;
	static boolean[] truth;
	
	static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) return;
		
		if (x < y) {
			parent[y] = x;
			for (int i = 1; i <= n; i++) {
				if (parent[i] == y) parent[i] = x;
			}
		} else {
			parent[x] = y;
			for (int i = 1; i <= n; i++) {
				if (parent[i] == x) parent[i] = y;
			}
		}
	}
	
	static void changeTruth(int x) {
		for (int i = 1; i <= n; i++) {
			if (parent[i] == x) truth[i] = true;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		truth = new boolean[n + 1];
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for (int i = 0; i < t; i++) {
			int p = Integer.parseInt(st.nextToken());
			truth[p] = true;
		}
		
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			graph.add(new ArrayList<>());
			
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			for (int j = 0; j < t; j++) {
				int p = Integer.parseInt(st.nextToken());
				graph.get(i).add(p);
			}
		}
		
		for (List<Integer> g : graph) {
			boolean flag = false;
			int p = g.get(0);
			
			for (int v : g) {
				union(p, v);
				if (truth[v]) flag = true;
			}
			
			if (flag) {
				changeTruth(parent[p]);
			}
		}
		
		int answer = 0;
		for (List<Integer> g: graph) {
			if (!truth[g.get(0)]) answer++;
		}
		
		System.out.println(answer);
	}
}
