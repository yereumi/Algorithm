import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 118;
    static boolean[] isPrime = new boolean[MAX + 1];

    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    static boolean canMake(int a) {
        for (int p = 2; p <= a; p++) {
            if (isPrime[p] && a - p >= 2 && isPrime[a - p]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sieve();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            sb.append(canMake(a) ? "Yes" : "No").append('\n');
        }

        System.out.print(sb.toString());
    }
}
