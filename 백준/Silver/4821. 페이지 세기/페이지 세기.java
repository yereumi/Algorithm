import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            String line = br.readLine();
            String[] ranges = line.split(",");

            boolean[] printed = new boolean[N + 1];

            for (String r : ranges) {
                if (r.contains("-")) {
                    String[] parts = r.split("-");
                    if (parts.length != 2) continue;

                    int low = Integer.parseInt(parts[0]);
                    int high = Integer.parseInt(parts[1]);

                    if (low > high) continue;

                    low = Math.max(low, 1);
                    high = Math.min(high, N);

                    for (int i = low; i <= high; i++) {
                        printed[i] = true;
                    }
                } else {
                    int page = Integer.parseInt(r);
                    if (page >= 1 && page <= N) {
                        printed[page] = true;
                    }
                }
            }

            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (printed[i]) count++;
            }

            System.out.println(count);
        }
    }
}
