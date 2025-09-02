import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] votes = new int[n];
            int sum = 0, max = -1, idx = -1, maxCount = 0;

            for (int i = 0; i < n; i++) {
                votes[i] = Integer.parseInt(br.readLine().trim());
                sum += votes[i];
                if (votes[i] > max) {
                    max = votes[i];
                    idx = i + 1;
                    maxCount = 1;
                } else if (votes[i] == max) {
                    maxCount++;
                }
            }

            if (maxCount > 1) {
                out.append("no winner\n");
            } else if (max * 2 > sum) {
                out.append("majority winner ").append(idx).append('\n');
            } else {
                out.append("minority winner ").append(idx).append('\n');
            }
        }
        System.out.print(out.toString());
    }
}