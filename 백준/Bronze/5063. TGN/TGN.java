import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 테스트 케이스 개수

        for (int i = 0; i < n; i++) {
            int r = sc.nextInt(); // 광고 X 수익
            int e = sc.nextInt(); // 광고 O 수익
            int c = sc.nextInt(); // 광고 비용

            int profitWithAd = e - c;

            if (profitWithAd > r) {
                System.out.println("advertise");
            } else if (profitWithAd == r) {
                System.out.println("does not matter");
            } else {
                System.out.println("do not advertise");
            }
        }

        sc.close();
    }
}