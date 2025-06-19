import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 입력: 1 ~ 11172
        char ch = (char) ('가' + n - 1);
        System.out.println(ch);
    }
}