import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] w = new int[n];
        for (int i = 0; i < n; i++) w[i] = Integer.parseInt(st.nextToken());

        long left = w[0];
        long right = w[1];

        for (int i = 2; i < n; i++) {
            if (left == right) {
                left += w[i];
            } else if (left < right) {
                left += w[i];
            } else {
                right += w[i];
            }
        }

        long diff = Math.abs(left - right);

        int[] weights = {100, 50, 20, 10, 5, 2, 1};
        int count = 0;
        for (int wgt : weights) {
            count += diff / wgt;
            diff %= wgt;
        }

        System.out.println(count);
    }
}