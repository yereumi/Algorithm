import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();

        int diff = k - a;
        if (diff % d != 0) {
            System.out.println("X");
            return;
        }
        int n = diff / d + 1;
        if (n >= 1) System.out.println(n);
        else System.out.println("X");
    }
}