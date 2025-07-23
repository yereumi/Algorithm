import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt(); // 고속철도 소요 시간
        int F = sc.nextInt(); // 항공편 소요 시간

        if (S <= F) {
            System.out.println("high speed rail");
        } else {
            System.out.println("flight");
        }
    }
}