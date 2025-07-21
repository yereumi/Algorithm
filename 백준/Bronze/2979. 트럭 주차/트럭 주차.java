import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int[] time = new int[101];

        for (int i = 0; i < 3; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            for (int t = start; t < end; t++) {
                time[t]++;
            }
        }

        int total = 0;
        for (int t = 1; t <= 100; t++) {
            if (time[t] == 1) total += A;
            else if (time[t] == 2) total += 2 * B;
            else if (time[t] == 3) total += 3 * C;
        }

        System.out.println(total);
    }
}