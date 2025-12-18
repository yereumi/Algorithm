import java.io.*;
import java.util.*;

public class Main {
    static boolean win(char[][] b, char c) {
        for (int i = 0; i < 3; i++) {
            if (b[i][0] == c && b[i][1] == c && b[i][2] == c) return true;
            if (b[0][i] == c && b[1][i] == c && b[2][i] == c) return true;
        }
        if (b[0][0] == c && b[1][1] == c && b[2][2] == c) return true;
        if (b[0][2] == c && b[1][1] == c && b[2][0] == c) return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(br.readLine().trim());
        char[][] b = new char[3][3];
        for (int i = 0; i < 3; i++) Arrays.fill(b[i], '.');

        int cur = start;
        for (int move = 0; move < 9; move++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            char mark = (cur == 1) ? 'O' : 'X';
            b[r][c] = mark;

            if (win(b, mark)) {
                System.out.println(cur);
                return;
            }

            cur = 3 - cur;
        }

        System.out.println(0);
    }
}
