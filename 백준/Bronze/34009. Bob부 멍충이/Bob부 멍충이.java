import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] A = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A, Collections.reverseOrder());

        long alice = 0, bob = 0;
        for (int i = 0; i < N; i++) {
            if ((N - i) % 2 == 0) {
                alice += A[i];
            } else {
                bob += A[i];
            }
            if (bob >= alice) {
                System.out.println("Bob");
                return;
            }
        }

        System.out.println("Alice");
    }
}