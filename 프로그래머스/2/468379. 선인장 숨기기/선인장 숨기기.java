import java.util.*;

class Solution {
    
    public static int M, N, H, W;
    public static int[][] board;
    public static int[][] result;
    
    public static void solve() {
        int[][] first = new int[M][N - W + 1];
        result = new int[M - H + 1][N - W + 1];
        
        for (int i = 0; i < M; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = 0; j < N; j++) {
                if (!dq.isEmpty() && dq.peekFirst() <= j - W) {
                    dq.pollFirst();
                }
                
                while (!dq.isEmpty() && board[i][dq.peekLast()] >= board[i][j] && board[i][j] != 0) {
                    dq.pollLast();
                }
                
                dq.offerLast(j);
                
                if (j >= W - 1) {
                    first[i][j - W + 1] = board[i][dq.peekFirst()];
                }
            }
        }
        
        for (int i = 0; i < N - W + 1; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = 0; j < M; j++) {
                if (!dq.isEmpty() && dq.peekFirst() <= j - H) {
                    dq.pollFirst();
                }
                while (!dq.isEmpty() && first[dq.peekLast()][i] >= first[j][i] && first[j][i] != 0) {   
                    dq.pollLast();
                }
                
                dq.offerLast(j);
                
                if (j >= H - 1) {
                    result[j - H + 1][i] = first[dq.peekFirst()][i];
                }
            }
        }
        
    }
    
    public static int[] solution(int m, int n, int h, int w, int[][] drops) {
        M = m;
        N = n;
        H = h;
        W = w;
        board = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(board[i], Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < drops.length; i++) {
            int[] d = drops[i];
            board[d[0]][d[1]] = i + 1;
        }
        
        solve();
        
        int max = -1, r = 0, c = 0;
        for (int i = 0; i <= M - H; i++) {
            for (int j = 0; j <= N - W; j++) {
                if (result[i][j] == 0) {
                    return new int[] { i, j };
                }
                
                if (result[i][j] > max) {
                    max = result[i][j];
                    r = i;
                    c = j;
                }
            }
        }
        
        return new int[] { r, c };
    }
}