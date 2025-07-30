import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];

        for (int i = 0; i < N; i++) a[i] = sc.nextInt();
        for (int i = 0; i < N; i++) b[i] = sc.nextInt();

        int moves = 0;
        for (int i = 0; i < N; i++) {
            if (a[i] > b[i]) {
                moves += (a[i] - b[i]);
            }
        }

        System.out.println(moves);
    }
}