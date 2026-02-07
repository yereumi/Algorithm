import java.io.*;
import java.util.*;

public class Main {
	
	static final int MOD = 10_000;
    static final int PISANO = 15_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
        	long n = Long.parseLong(br.readLine());
        	
        	if (n == -1) break;
        	
            int idx = (int)(n % PISANO);

            int[] fib = new int[PISANO + 1];
            fib[0] = 0;
            fib[1] = 1;

            for (int i = 2; i <= idx; i++) {
                fib[i] = (fib[i - 1] + fib[i - 2]) % MOD;
            }

            sb.append(fib[idx]).append("\n");
        }
        
        System.out.println(sb.toString());
        
        br.close();
    }
}
