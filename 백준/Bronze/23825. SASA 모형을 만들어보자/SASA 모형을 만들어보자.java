import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong(), M = sc.nextLong();
        System.out.println(Math.min(N / 2, M / 2));
    }
}