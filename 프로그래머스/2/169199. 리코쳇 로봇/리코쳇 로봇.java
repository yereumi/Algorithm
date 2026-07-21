import java.io.*;
import java.util.*;

class Solution {
    
    static char[][] charBoard;
    static int N, M, rr, rc, gr, gc;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    
    static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
    
    static int solve() {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][4];
        dq.offer(new int[] { rr, rc, 0 });
        
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur[0];
                int nc = cur[1];
                int nt = cur[2] + 1;
                
                if (visited[nr][nc][i]) continue;
                visited[nr][nc][i] = true;
                
                while (true) {
                    nr += dr[i];
                    nc += dc[i];
                    
                    if (!isValid(nr, nc) || charBoard[nr][nc] == 'D') break;
                }
                
                nr -= dr[i];
                nc -= dc[i];
                if (charBoard[nr][nc] == 'G') return nt;
                dq.offer(new int[] { nr, nc, nt });
            }
        }
        
        return -1;
    }
    
    public static int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        charBoard = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                charBoard[i][j] = board[i].charAt(j);
                if (charBoard[i][j] == 'R') {
                    rr = i;
                    rc = j;
                }
                if (charBoard[i][j] == 'G') {
                    gr = i;
                    gc = j;
                }
            }
        }
        
        return solve();
    }
}
