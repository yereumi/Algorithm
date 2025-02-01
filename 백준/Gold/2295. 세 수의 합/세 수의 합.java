import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] num = new long[n];
        for (int i = 0; i < n; i++) {
            num[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(num);
        Set<Long> sums = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sums.add(num[i] + num[j]);
            }
        }

        long max = Long.MIN_VALUE;
        for (int k = n - 1; k >= 0; k--) {
            for (int l = 0; l < k; l++) {
                long target = num[k] - num[l];
                if (sums.contains(target)) {
                    max = Math.max(max, num[k]);
                }
            }
        }
        System.out.println(max);
    }
}