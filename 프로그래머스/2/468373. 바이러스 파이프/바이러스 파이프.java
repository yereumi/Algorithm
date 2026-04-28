/**
1. 타입 별로 간선 따로 저장
2. 백트래킹으로 depth k번
3. 각 감염됐을 때 bfs로 같은 파이프라인 전파
**/

import java.util.*;

class Solution {
    public static int answer, N, K;
    public static List<List<int[]>> graph;
    public static List<int[]> pipeA, pipeB, pipeC;
    
    public static void backtracking(int depth, boolean[] infected) {
        if (depth == K) {
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += infected[i] ? 1 : 0;
            }
            
            answer = Math.max(answer, cnt);
            return;
        }
        
        boolean[] newInfected = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            newInfected[i] = infected[i];
        }
        
        for (int[] p : pipeA) {
            int x = p[0], y = p[1];
            if (infected[x]) {
                bfs(x, 1, newInfected);
            }
            if (infected[y]) {
                bfs(y, 1, newInfected);
            }
        }
        
        backtracking(depth + 1, newInfected);
        
        newInfected = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            newInfected[i] = infected[i];
        }
        
        for (int[] p : pipeB) {
            int x = p[0], y = p[1];
            if (infected[x]) {
                bfs(x, 2, newInfected);
            }
            if (infected[y]) {
                bfs(y, 2, newInfected);
            }
        }
        
        backtracking(depth + 1, newInfected);
        
        newInfected = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            newInfected[i] = infected[i];
        }
        
        for (int[] p : pipeC) {
            int x = p[0], y = p[1];
            if (infected[x]) {
                bfs(x, 3, newInfected);
            }
            if (infected[y]) {
                bfs(y, 3, newInfected);
            }
        }
        
        backtracking(depth + 1, newInfected);
    }
    
    public static void bfs(int node, int type, boolean[] infected) {
        infected[node] = true;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(node);
        
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            
            for (int[] g : graph.get(cur)) {
                if (infected[g[0]]) continue;
                
                if (g[1] == type) {
                    dq.offer(g[0]);
                    infected[g[0]] = true;
                }
            }
        }
    }
    
    public static int solution(int n, int infection, int[][] edges, int k) {
        N = n;
        K = k;
        
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        pipeA = new ArrayList<>();
        pipeB = new ArrayList<>();
        pipeC = new ArrayList<>();
        
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int t = edge[2];
            
            graph.get(x).add(new int[] { y, t });
            graph.get(y).add(new int[] { x, t });
            
            if (t == 1) {
                pipeA.add(new int[] { x, y });
            } else if (t == 2) {
                pipeB.add(new int[] { x, y });
            } else {
                pipeC.add(new int[] { x, y });
            }
        }
        
        answer = 0;
        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;
        backtracking(0, infected);
        
        return answer;
    }
}