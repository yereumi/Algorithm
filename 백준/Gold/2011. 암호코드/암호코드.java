import java.io.*;
import java.util.*;

public class Main {
	
	static long MOD = 1000000L;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String num = br.readLine();
    	int len = num.length();
    	
    	long[] dp = new long[len + 1];
    	dp[0] = 1;
    	
    	if (num.charAt(0) == '0') {
            System.out.println(0);
            return;
        }
    	
    	for (int i = 1; i <= len; i++) {
            dp[i] = 0;

            int one = num.charAt(i - 1) - '0';
            if (one >= 1) {
                dp[i] = (dp[i] + dp[i - 1]) % MOD;
            }

            if (i >= 2) {
                int two = (num.charAt(i - 2) - '0') * 10 + one;
                if (two >= 10 && two <= 26) {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD;
                }
            }
        }

        System.out.println(dp[len] % MOD);
    }
}