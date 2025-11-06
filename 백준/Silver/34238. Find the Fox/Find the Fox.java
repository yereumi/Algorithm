import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;

    static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

    static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int count = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (board[r][c] != 'F') continue;

                for (int d = 0; d < 8; d++) {
                    int r1 = r + dr[d];
                    int c1 = c + dc[d];
                    int r2 = r + 2 * dr[d];
                    int c2 = c + 2 * dc[d];

                    if (isValid(r1, c1) && isValid(r2, c2)) {
                        if (board[r1][c1] == 'O' && board[r2][c2] == 'X') {
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
