import java.util.*;

class Solution {
    
    static int[][] board_;
    static int[][][] visited;
    static int n, minCost;
    static int[] dr = new int[] { 1, -1, 0, 0 }; // 상, 하, 좌, 우 - 0, 1, 2, 3
    static int[] dc = new int[] { 0, 0, 1, -1 };
    
    static boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
    
    static void dfs(int r, int c, int d, int cost) {
        if (r == n - 1 && c == n - 1) {
            minCost = Math.min(minCost, cost);
            return;
        }
        
        // System.out.println(r + ", " + c + ", " + cost);
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!isValid(nr, nc) || board_[nr][nc] == 1) continue;
            int nowCost = cost;
            if (i == d || d == -1) nowCost += 100;
            else nowCost += 600;
                
            if (visited[nr][nc][i] < nowCost) continue;
            visited[nr][nc][i] = nowCost;
            dfs(nr, nc, i, nowCost);
        }
    }
    
    public static int solution(int[][] board) {
        n = board.length;
        board_ = board;
        minCost = Integer.MAX_VALUE;
        visited = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);   
            }
        }
        
        dfs(0, 0, -1, 0);
        
        return minCost;
    }
}