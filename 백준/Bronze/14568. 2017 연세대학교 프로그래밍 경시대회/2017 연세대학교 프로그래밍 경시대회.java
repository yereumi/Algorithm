import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int A = 1; A <= N; A++) {
            if (A % 2 == 1) continue;

            for (int B = 1; B <= N; B++) {
                for (int C = 1; C <= N; C++) {
                    if (A + B + C != N) continue;
                    if (C < B + 2) continue;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}