import java.io.*;

public class Main {

    static final long MOD = 1_000_000_007;

    static long[][] multiply(long[][] a, long[][] b) {
        return new long[][]{
            {
                (a[0][0]*b[0][0] + a[0][1]*b[1][0]) % MOD,
                (a[0][0]*b[0][1] + a[0][1]*b[1][1]) % MOD
            },
            {
                (a[1][0]*b[0][0] + a[1][1]*b[1][0]) % MOD,
                (a[1][0]*b[0][1] + a[1][1]*b[1][1]) % MOD
            }
        };
    }

    static long fib(long n) {
        long[][] result = {
            {1,0},
            {0,1}
        };

        long[][] base = {
            {1,1},
            {1,0}
        };

        while (n > 0) {
            if ((n & 1) == 1) {
                result = multiply(result, base);
            }

            base = multiply(base, base);

            n >>= 1;
        }

        return result[0][1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.println(fib(n));
    }
}
