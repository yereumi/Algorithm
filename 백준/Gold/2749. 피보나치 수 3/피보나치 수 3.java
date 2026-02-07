import java.io.*;

public class Main {

    static final int MOD = 1_000_000;
    static final int PISANO = 1_500_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        int idx = (int)(n % PISANO);

        int[] fib = new int[PISANO + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= idx; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % MOD;
        }

        System.out.println(fib[idx]);
    }
}
