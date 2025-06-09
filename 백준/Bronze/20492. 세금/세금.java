import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int case1 = N - N * 22 / 100;
        int case2 = N - N * 44 / 1000;

        System.out.println(case1 + " " + case2);
    }
}