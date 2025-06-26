import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int minBreadTime = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a <= b) {
                minBreadTime = Math.min(minBreadTime, b);
            }
        }

        if (minBreadTime == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minBreadTime);
        }

        sc.close();
    }
}