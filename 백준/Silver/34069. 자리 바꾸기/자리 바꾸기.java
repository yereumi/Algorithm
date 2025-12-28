import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if ((N & 1) == 1 && (M & 1) == 1) {
            System.out.println("No");
            return;
        }

        System.out.println("Yes");

        int[][] B = new int[N][M];

        if ((M & 1) == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j += 2) {
                    B[i][j] = A[i][j + 1];
                    B[i][j + 1] = A[i][j];
                }
            }
        } else {
            for (int i = 0; i < N; i += 2) {
                for (int j = 0; j < M; j++) {
                    B[i][j] = A[i + 1][j];
                    B[i + 1][j] = A[i][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(B[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
