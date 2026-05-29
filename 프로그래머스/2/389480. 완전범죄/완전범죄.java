import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 1_000_000;
        
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for (int[] i : info) {
            int a = i[0], b = i[1];
            
            int[] next = new int[m];
            Arrays.fill(next, INF);

            for (int j = 0; j < m; j++) {
                if (dp[j] == INF) continue;

                // A가 훔치는 경우
                int nextA = dp[j] + a;
                if (nextA < n) {
                    next[j] = Math.min(next[j], nextA);
                }

                // B가 훔치는 경우
                int nextB = j + b;
                if (nextB < m) {
                    next[nextB] = Math.min(next[nextB], dp[j]);
                }
            }
            
            dp = next;
        }
        
        int answer = INF;
        for (int a : dp) {
            answer = Math.min(answer, a);
        }

        return answer == INF ? -1 : answer;
    }
}
