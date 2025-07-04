import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int count = 0;

        for (long i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                long a = i;
                long b = N / i;
                count += (a == b) ? 1 : 2;
            }
        }

        System.out.println(count);
    }
}