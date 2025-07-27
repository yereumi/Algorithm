import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] board = new int[n][m];
        int[][] nineCount = new int[n][m];
        int totalNines = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                nineCount[i][j] = countNines(board[i][j]);
                totalNines += nineCount[i][j];
            }
        }

        int[] rowSum = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowSum[i] += nineCount[i][j];
            }
        }

        int[] colSum = new int[m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                colSum[j] += nineCount[i][j];
            }
        }

        int maxRemove = 0;
        for (int i = 0; i < n; i++) {
            maxRemove = Math.max(maxRemove, rowSum[i]);
        }
        for (int j = 0; j < m; j++) {
            maxRemove = Math.max(maxRemove, colSum[j]);
        }

        System.out.println(totalNines - maxRemove);
    }

    private static int countNines(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == 9) count++;
            num /= 10;
        }
        return count;
    }
}