import java.util.*;

/*
1. dfs로 그래프의 끝 점 찾기
2. 끝 점은 무조건 등대 안켜고 시작
3. bfs로 flag 설정해줘서 정점마다 등대를 키고 안키고 반복
*/

class Solution {
    
     static List<List<Integer>> graph;
    static boolean[] visited;
    static int[][] dp;
    
    public int dfs(int node) {
        visited[node] = true;
        dp[node][1] = 1;  // 이 노드를 켰을 경우
        
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
                dp[node][0] += dp[next][1];  // 현재 노드를 안 켰다면, 자식은 무조건 켜야 함
                dp[node][1] += Math.min(dp[next][0], dp[next][1]);  // 현재 노드를 켰다면, 자식은 켜거나 안 켜거나 작은 값 선택
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
        dp = new int[n + 1][2];  // dp[i][0] = i를 안 켰을 때 최소 등대 수, dp[i][1] = i를 켰을 때 최소 등대 수
        
        return dfs(1);  // 루트 노드부터 탐색 시작
    }
}