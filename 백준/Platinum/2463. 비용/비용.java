import java.util.*;
import java.io.*;

public class Main {
    
    static int read() throws Exception {
		int c, n = System.in.read() & 15;
		boolean m = n == 13;
		if (m)
			n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return m ? ~n + 1 : n;
	}
    
	static int n, m;
	static int[] parent, child;

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	public static long union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		if (parentA == parentB)
			return 0;
		parent[parentB] = parentA;
		long cnt = (long) child[parentA] * child[parentB];
		child[parentA] += child[parentB];
		child[parentB] = 0;
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		List<int[]> list = new ArrayList<>();
		int[] weight = new int[m];
		long weightSum = 0;
		for (int i = 0; i < m; i++) {
			int x = read();
			int y = read();
			int w = read();
			if (x < y) list.add(new int[] { x, y, w });
			else list.add(new int[] { y, x, w });
			weightSum += w;
		}
        Collections.sort(list, (o1, o2) -> o2[2] - o1[2]);
        
		parent = new int[n + 1];
		child = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			child[i] = 1;
		}

		long answer = 0;
		for (int[] now : list) {
			answer += weightSum * union(now[0], now[1]);
			answer %= 1000000000;
			weightSum -= now[2];
		}
		System.out.println(answer);
	}
}