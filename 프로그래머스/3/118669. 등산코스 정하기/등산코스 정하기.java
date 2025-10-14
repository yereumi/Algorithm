import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int v, w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] p : paths) {
            int a = p[0], b = p[1], w = p[2];
            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));
        }

        boolean[] isGate = new boolean[n + 1];
        boolean[] isSummit = new boolean[n + 1];
        for (int g : gates) isGate[g] = true;
        for (int s : summits) isSummit[s] = true;

        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int g : gates) {
            dist[g] = 0;
            pq.offer(new Node(g, 0));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.w > dist[cur.v]) continue;
            if (isSummit[cur.v]) continue;

            for (Node next : graph.get(cur.v)) {
                if (isGate[next.v]) continue;

                int intensity = Math.max(dist[cur.v], next.w);
                if (intensity < dist[next.v]) {
                    dist[next.v] = intensity;
                    pq.offer(new Node(next.v, intensity));
                }
            }
        }

        Arrays.sort(summits);
        int minSummit = -1;
        int minIntensity = INF;
        for (int s : summits) {
            if (dist[s] < minIntensity) {
                minIntensity = dist[s];
                minSummit = s;
            }
        }

        return new int[] {minSummit, minIntensity};
    }
}