import java.util.*;
import java.io.*;

public class Main {

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
	static int n, m;
	static List<List<int[]>> graph;
	static long[] dist;
	static PriorityQueue<long[]> pq;
	
	static void dijkstra() {
        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            long[] now = pq.poll();
            int city = (int)now[0];
            long d = now[1];

            if (visited[city]) continue;
            visited[city] = true;

            for (int[] next : graph.get(city)) {
                int nextCity = (int)next[0];
                long nextDist = next[1];

                if (dist[nextCity] > d + nextDist) {
                    dist[nextCity] = d + nextDist;
                    pq.offer(new long[] { nextCity, dist[nextCity] });
                }
            }
        }
    }

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		int x = read();
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());		
		}
		for (int i = 0; i < m; i++) {
			int s = read();
			int e = read();
			int w = read();
			graph.get(e).add(new int[] { s, w });
		}
		dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        pq = new PriorityQueue<>((o1, o2) -> (int)o1[1] - (int)o2[1]);
		for (int i = 0; i < x; i++) {
			int p = read();
			dist[p] = 0;
			pq.offer(new long[] { p, 0 });
		}
		dijkstra();
		long maxCity = 0, maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (maxDist < dist[i]) {
            	maxDist = dist[i];
            	maxCity = i;
            }
        }
        System.out.println(maxCity + "\n" + maxDist);
	}
}