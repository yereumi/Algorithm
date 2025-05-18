import java.util.*;

class Solution {
    List<List<Integer>> graph;
    boolean[] visited;
    int[] depth;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            int[] now = edge[i];
            graph.get(now[0]).add(now[1]);
            graph.get(now[1]).add(now[0]);
        }
        visited = new boolean[n + 1];
        depth = new int[n + 1];
        bfs();
        
        Arrays.sort(depth);
        int max = 0;
        for (int i : depth) {
            if (i > max) {
                answer = 1;
                max = i;
            } else if (i == max) answer++;
        }
        
        return answer;
    }
    
    private void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { 1, 0 });
        visited[1] = true;
        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            int v = now[0], d = now[1];
            for (int i : graph.get(v)) {
                if (!visited[i]) {
                    dq.offer(new int[] { i, d + 1 });
                    visited[i] = true;
                    depth[i] = d + 1;
                }
            }
        }
    }
}