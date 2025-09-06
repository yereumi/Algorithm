import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long[][] dp = new long[m + 1][n + 1];
        int[][] profit = new int[n + 1][m + 1];
        int[][] choice = new int[m + 1][n + 1];
        int[] invest = new int[m + 1];
        
        for (int i = 1; i <= n; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int j = 0; j <= m; j++) {
        		profit[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // dp[i][j] : 회사 i까지 투자했을 때 j금액에서의 최대값
        for (int i = 1; i <= m; i++) { // 회사
        	for (int j = 1; j <= n; j++) { // 투자 비용
        		for (int k = 0; k <= j; k++) {
        			if (dp[i][j] < dp[i - 1][j - k] + profit[k][i]) {
        				dp[i][j] = dp[i - 1][j - k] + profit[k][i];
        				choice[i][j] = k;
        			}        		
        		}
        	}
        }
        
        int money = n;
        int idx = m;
        while (money != 0) {
            invest[idx] = choice[idx][money];
        	money -= invest[idx--];
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(dp[m][n]).append("\n");
        for (int i = 1; i <= m; i++) {
        	sb.append(invest[i]).append(" ");
        }
        
        System.out.println(sb);
    }
}