import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        int turn = 1;

        while (sum + turn <= N) {
            sum += turn;
            turn++;
        }

        int extra = 0;
        while (true) {
            int total = N + extra;
            int tmpSum = 0;
            int tmpTurn = 1;

            while (tmpSum + tmpTurn <= total) {
                tmpSum += tmpTurn;
                tmpTurn++;
            }

            if ((tmpTurn - 1) % 2 == 1) {
                System.out.println(extra);
                break;
            }

            extra++;
        }
    }
}