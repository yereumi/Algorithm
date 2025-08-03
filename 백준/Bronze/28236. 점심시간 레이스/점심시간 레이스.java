import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long bestTime = Long.MAX_VALUE;
        int bestClass = 1;

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            long f = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());

            long timeViaLeft = d + (f - 1) + (m + 2);
            long timeViaRight = (m + 1 - d) + (f - 1) + 1;
            long time = Math.min(timeViaLeft, timeViaRight);

            if (time < bestTime) {
                bestTime = time;
                bestClass = i;
            }
        }

        System.out.println(bestClass);
    }
}