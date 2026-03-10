import java.io.*;
import java.util.*;

public class Main {

    static final long MOD = 1_000_000_007L;

    static long pow(long a, long exp) {
        long result = 1L;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            exp >>= 1;
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long factN = 1L;
        long factK = 1L;
        long factNK = 1L;

        for (int i = 1; i <= N; i++) {
            factN = (factN * i) % MOD;
            if (i == K) factK = factN;
            if (i == N - K) factNK = factN;
        }

        long denominator = (factK * factNK) % MOD;
        long inverse = pow(denominator, MOD - 2);

        long answer = (factN * inverse) % MOD;
        System.out.println(answer);
    }
}
