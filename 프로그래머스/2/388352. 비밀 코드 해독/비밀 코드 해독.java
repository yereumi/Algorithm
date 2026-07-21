import java.util.*;

class Solution {
    
    public static int N, M, answer;
    public static int[][] Q;
    public static int[] ANS;
    public static int[] arr;
    
    public static void combination(int num, int depth) {
        if (depth == 5) {
            if (solve()) answer++;
            return;
        }
        
        for (int i = num; i <= N; i++) {
            arr[depth] = i;
            combination(i + 1, depth + 1);
        }
    } 
    
    public static boolean solve() {
        for (int i = 0; i < M; i++) {
            int[] now = Q[i];
            
            int same = 0;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (now[j] == arr[k]) same++;
                }
                
                if (same > ANS[i]) return false;
            }
            
            if (same != ANS[i]) return false;
        }
        
        return true;
    }
    
    public static int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        N = n;
        M = q.length;
        Q = q;
        ANS = ans;
        
        arr = new int[5];
        combination(1, 0);
        
        
        return answer;
    }
}
