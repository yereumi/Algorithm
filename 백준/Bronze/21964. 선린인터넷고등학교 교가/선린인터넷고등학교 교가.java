import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine()); // 첫 줄: 문자열 길이
        String s = sc.nextLine();                // 둘째 줄: 문자열
        
        // 마지막 5글자 출력
        System.out.println(s.substring(n - 5));
    }
}