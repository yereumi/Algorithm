import java.io.*;
import java.util.*;

public class Main {
	
	static long MOD = 1000_000_000 + 7;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long[] dp = new long[5];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
        	char c = s.charAt(i);
        	if (c == 'W') {
        		dp[1] = (dp[1] + dp[0]) % MOD;
        	} else if (c == 'H') {
        		dp[2] = (dp[2] + dp[1]) % MOD;
        	} else if (c == 'E') {
        		dp[4] = (dp[4] * 2) % MOD;
        		dp[4] = (dp[4] + dp[3]) % MOD;
        		dp[3] = (dp[3] + dp[2]) % MOD;
        	}
        }
        
        System.out.println(dp[4] % MOD);
    }
}
