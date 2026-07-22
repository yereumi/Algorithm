import java.util.*;

class Solution {
    
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int answer = 0;
    
    static int[] dr = { -1, -1, -1 };
    static int[] dc = { 0, -1, 1 };
    
    static boolean isValid(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;   
    }
    
    static boolean isPossible(int r, int c) {
        for (int i = 0; i < 3; i++) {
            int nr = r, nc = c;
            while (true) {
                nr += dr[i];
                nc += dc[i];
                
                if (!isValid(nr, nc)) break;;
                if (visited[nr][nc]) return false;
            }
        }
        
        return true;
    }
    
    static void backtracking(int r, int c, int depth) {
        if (depth == N) {
            answer++;
            return;
        }
        
        for (int j = c; j < N; j++) {
            if (isPossible(r, j)) {
                visited[r][j] = true;
                backtracking(r + 1, 0, depth + 1);
                visited[r][j] = false;
            }
        }
    }
    
    public int solution(int n) {
        N = n;
        board = new int[N][N];
        visited = new boolean[N][N];
        
        backtracking(0, 0, 0);
        return answer;
    }
}