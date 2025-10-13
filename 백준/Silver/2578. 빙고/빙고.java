import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited = new boolean[5][5];
    static int[][] board = new int[5][5];
    static Map<Integer, int[]> pos = new HashMap<>();

    static int countBingo() {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            boolean ok = true;
            for (int j = 0; j < 5; j++)
                if (!visited[i][j]) ok = false;
            if (ok) cnt++;
        }
        for (int j = 0; j < 5; j++) {
            boolean ok = true;
            for (int i = 0; i < 5; i++)
                if (!visited[i][j]) ok = false;
            if (ok) cnt++;
        }
        boolean ok = true;
        for (int i = 0; i < 5; i++)
            if (!visited[i][i]) ok = false;
        if (ok) cnt++;
        ok = true;
        for (int i = 0; i < 5; i++)
            if (!visited[i][4 - i]) ok = false;
        if (ok) cnt++;

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                pos.put(board[i][j], new int[] { i, j });
            }
        }

        int count = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                count++;
                int num = Integer.parseInt(st.nextToken());
                int[] p = pos.get(num);
                visited[p[0]][p[1]] = true;

                if (countBingo() >= 3) {
                    System.out.println(count);
                    return;
                }
            }
        }
    }
}