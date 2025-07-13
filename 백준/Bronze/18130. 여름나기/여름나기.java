import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();

        int resultIndex = 0;
        long minTotalCost = Long.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int P = sc.nextInt();
            int K = sc.nextInt();
            int C = sc.nextInt();

            int t = Q / K;
            if (Q % K == 0) t--;

            long addCost = (long) C * t * (t + 1) / 2;
            long totalCost = (long) P + addCost;

            if (totalCost < minTotalCost) {
                minTotalCost = totalCost;
                resultIndex = i;
            }
        }

        System.out.println(resultIndex + " " + minTotalCost);
    }
}