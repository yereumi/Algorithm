import java.io.*;
import java.util.*;

public class Main {

    static final int N = 10;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken()) - 1;
        int sc = Integer.parseInt(st.nextToken()) - 1;

        char[][] map = new char[N][N];
        boolean[] bombRow = new boolean[N];
        boolean[] bombCol = new boolean[N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'o') {
                    bombRow[i] = true;
                    bombCol[j] = true;
                }
            }
        }

        if (!bombRow[sr] && !bombCol[sc]) {
            System.out.println(0);
            return;
        }

        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;

                if (!bombRow[nr] && !bombCol[nc]) {
                    System.out.println(d + 1);
                    return;
                }

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, d + 1});
            }
        }
    }
}
