import java.util.*;

class Solution {
    
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[][] dp;
    
    public int dfs(int node) {
        visited[node] = true;
        dp[node][1] = 1;
        
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
                dp[node][0] += dp[next][1];
                dp[node][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
        return Math.min(dp[node][0], dp[node][1]);
    }
    
    public int solution(int n, int[][] lighthouse) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for (int[] edge : lighthouse) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        visited = new boolean[n + 1];
        dp = new int[n + 1][2];
        return dfs(1);
    }
}