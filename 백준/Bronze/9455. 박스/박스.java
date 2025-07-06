import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] grid = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            int totalMoves = 0;

            for (int col = 0; col < n; col++) {
                int empty = 0;

                for (int row = m - 1; row >= 0; row--) {
                    if (grid[row][col] == 0) {
                        empty++;
                    } else {
                        totalMoves += empty;
                    }
                }
            }

            System.out.println(totalMoves);
        }

        sc.close();
    }
}