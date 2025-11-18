import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());

        if (K >= N) {
            System.out.println(N);
            return;
        }

        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        boolean[] bad = new boolean[N + 1];

        for (int p = K + 1; p <= N; p++) {
            if (isPrime[p]) {
                for (int multiple = p; multiple <= N; multiple += p) {
                    bad[multiple] = true;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!bad[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
