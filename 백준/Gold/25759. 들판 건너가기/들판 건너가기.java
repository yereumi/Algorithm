import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[] flower;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        flower = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	flower[i] = Integer.parseInt(st.nextToken());
        }
        
        long[] dp = new long[101];
        Arrays.fill(dp, Long.MIN_VALUE);
        
        for (int i = 0; i < n; i++) {
        	int now = flower[i];
        	long max = Long.MIN_VALUE;
        	for (int j = 1; j < 101; j++) {
        		if (dp[j] >= 0) {
            		max = Math.max(max, dp[j] + (j - now) * (j - now));
        		}
        	}
        	dp[now] = (int) Math.max(dp[now], max);
        }
        
        long max = 0;
        for (int i = 1; i < 101; i++) {
        	max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
