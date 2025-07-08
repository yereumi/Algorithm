import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int total = 0;

        for (int a = 0; a <= N; a++) {
            for (int b = a; b <= N; b++) {
                total += a + b;
            }
        }

        System.out.println(total);
    }
}