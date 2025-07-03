import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int count = 0;
        int current = N;

        while (current > 0) {
            count += current;
            current = current / M;
        }

        System.out.println(count);
    }
}