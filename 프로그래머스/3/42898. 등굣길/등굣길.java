import java.util.*;

class Solution {
    
    static final int MOD = 1_000_000_007;
    static int M, N;
    static int[][] map;
    
    static int[] dr = { 1, 0 };
    static int[] dc = { 0, 1 };
    
    static boolean isValid(int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }
    
    public int solution(int m, int n, int[][] puddles) {
        M = m;
        N = n;
        map = new int[M][N];
        
        for (int[] p : puddles) {
            int r = p[0] - 1;
            int c = p[1] - 1;
            map[r][c] = -1;
        }
        
        map[0][0] = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
            	if (map[i][j] == -1) continue;
                if (isValid(i - 1, j) && map[i - 1][j] != -1) map[i][j] += map[i - 1][j];
                if (isValid(i, j - 1) && map[i][j - 1] != -1) map[i][j] += map[i][j - 1];
                
                map[i][j] %= MOD;
            }
        }
        
        return map[M - 1][N - 1];
    }
}