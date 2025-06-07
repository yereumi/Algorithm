import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int K = sc.nextInt();
        int H = sc.nextInt();

        int sum = S + K + H;

        if (sum >= 100) {
            System.out.println("OK");
        } else {
            if (S < K && S < H) {
                System.out.println("Soongsil");
            } else if (K < S && K < H) {
                System.out.println("Korea");
            } else {
                System.out.println("Hanyang");
            }
        }
    }
}