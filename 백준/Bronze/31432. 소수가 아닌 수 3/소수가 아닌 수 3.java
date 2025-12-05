import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] digits = new int[N];
        for (int i = 0; i < N; i++) {
            digits[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> nonPrimeDigits = new HashSet<>(Arrays.asList(0, 1, 4, 6, 8, 9));
        for (int d : digits) {
            if (nonPrimeDigits.contains(d)) {
                System.out.println("YES");
                System.out.println(d);
                return;
            }
        }

        int d = digits[0];
        System.out.println("YES");
        System.out.println("" + d + d);
    }
}
