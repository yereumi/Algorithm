import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt(), B = sc.nextInt();
        int C = sc.nextInt(), D = sc.nextInt();

        int firstSum = A + B;
        int secondSum = C + D;

        int pseudoEast = (0 + firstSum - 1) % 4;
        int trueEast = (pseudoEast + secondSum - 1) % 4;

        System.out.println(trueEast + 1);
    }
}