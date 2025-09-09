import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1,-1,-1,0,0,1,1,1};
    static final int[] dy = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(line);
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if (R == 0 && C == 0) break;

            char[][] board = new char[R][C];
            int[][] cnt = new int[R][C];

            for (int i = 0; i < R; i++) {
                String row = br.readLine();
                while (row != null && row.length() < C) row += br.readLine(); // robustness
                board[i] = row.toCharArray();
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == '*') {
                        for (int d = 0; d < 8; d++) {
                            int ni = i + dx[d], nj = j + dy[d];
                            if (0 <= ni && ni < R && 0 <= nj && nj < C) cnt[ni][nj]++;
                        }
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == '*') out.append('*');
                    else out.append((char)('0' + cnt[i][j]));
                }
                out.append('\n');
            }
        }
        System.out.print(out.toString());
    }
}