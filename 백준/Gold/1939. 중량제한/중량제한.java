import java.io.*;
import java.util.*;

public class Main {

	static int n, m, start, end;
	static List<List<int[]>> graph;
	static int[] maxWeight;
	
	static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        pq.offer(new int[] {start, Integer.MAX_VALUE});
        maxWeight[start] = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int weight = cur[1];

            if (maxWeight[node] > weight) continue;

            for (int[] next : graph.get(node)) {
                int nxt = next[0];
                int limit = next[1];

                int newWeight = Math.min(weight, limit);

                if (maxWeight[nxt] < newWeight) {
                    maxWeight[nxt] = newWeight;
                    pq.offer(new int[] {nxt, newWeight});
                }
            }
        }
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maxWeight = new int[n + 1];
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			maxWeight[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new int[] { b, c });
			graph.get(b).add(new int[] { a, c });
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        maxWeight = new int[n + 1];
        dijkstra();
		System.out.println(maxWeight[end]);
	}
}
