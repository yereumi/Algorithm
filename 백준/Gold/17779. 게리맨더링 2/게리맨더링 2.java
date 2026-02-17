import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] A;
    static int total;
    static int answer = Integer.MAX_VALUE;

    static boolean isValid(int x, int y, int d1, int d2) {
        return x + d1 + d2 < N && y - d1 >= 0 && y + d2 < N;
    }

    static void solve() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (!isValid(x, y, d1, d2)) continue;

                        boolean[][] border = new boolean[N][N];

                        // 경계선 표시
                        for (int i = 0; i <= d1; i++) {
                            border[x + i][y - i] = true;
                            border[x + d2 + i][y + d2 - i] = true;
                        }
                        for (int i = 0; i <= d2; i++) {
                            border[x + i][y + i] = true;
                            border[x + d1 + i][y - d1 + i] = true;
                        }

                        int[] p = new int[5];

                        // 1번 선거구
                        for (int r = 0; r < x + d1; r++) {
                            for (int c = 0; c <= y; c++) {
                                if (border[r][c]) break;
                                p[0] += A[r][c];
                            }
                        }

                        // 2번 선거구
                        for (int r = 0; r <= x + d2; r++) {
                            for (int c = N - 1; c > y; c--) {
                                if (border[r][c]) break;
                                p[1] += A[r][c];
                            }
                        }

                        // 3번 선거구
                        for (int r = x + d1; r < N; r++) {
                            for (int c = 0; c < y - d1 + d2; c++) {
                                if (border[r][c]) break;
                                p[2] += A[r][c];
                            }
                        }

                        // 4번 선거구
                        for (int r = x + d2 + 1; r < N; r++) {
                            for (int c = N - 1; c >= y - d1 + d2; c--) {
                                if (border[r][c]) break;
                                p[3] += A[r][c];
                            }
                        }

                        // 5번 선거구
                        p[4] = total - (p[0] + p[1] + p[2] + p[3]);

                        int min = p[0], max = p[0];
                        for (int i = 1; i < 5; i++) {
                            min = Math.min(min, p[i]);
                            max = Math.max(max, p[i]);
                        }
                        
                        answer = Math.min(answer, max - min);
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];

        total = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                total += A[i][j];
            }
        }

        solve();
        System.out.println(answer);
    }
}
