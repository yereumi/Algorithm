import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 받기
        int N = sc.nextInt();
        
        // 1부터 N까지의 합 구하기
        int sum = N * (N + 1) / 2;
        
        // 1부터 N까지의 합을 제곱한 값 구하기
        int squareOfSum = sum * sum;
        
        // 1부터 N까지의 수의 세제곱의 합 구하기
        int sumOfCubes = 0;
        for (int i = 1; i <= N; i++) {
            sumOfCubes += i * i * i;
        }
        
        // 출력
        System.out.println(sum);
        System.out.println(squareOfSum);
        System.out.println(sumOfCubes);
    }
}