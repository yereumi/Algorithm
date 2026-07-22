import java.util.*;

class Solution {
    
    static int answer = 0;
    static int K, N;
    static int[][] DG;
    static boolean[] visited;
    
    static void backtracking(int cnt) {
        answer = Math.max(answer, cnt);
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (K < DG[i][0]) continue;
            
            K -= DG[i][1];
            visited[i] = true;
            backtracking(cnt + 1);
            K += DG[i][1];
            visited[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        K = k;
        N = dungeons.length;
        DG = new int[N][2];
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            DG[i][0] = dungeons[i][0];
            DG[i][1] = dungeons[i][1];
        }
        
        backtracking(0);
        
        return answer;
    }
}