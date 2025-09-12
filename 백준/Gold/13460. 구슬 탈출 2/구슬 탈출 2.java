import java.io.*;
import java.util.*;

public class Main {

    static int n, m, hr, hc;
    static char[][] board;
    static int[] beads;
    static int[] dr = new int[] { -1, 1, 0, 0 };
    static int[] dc = new int[] { 0, 0, -1, 1 };

    static boolean isValid(int r, int c) {
        return r >= 1 && r < n - 1 && c >= 1 && c < m - 1;
    }

    static int[] roll(int r, int c, int dir) {
        int steps = 0;
        int nr = r, nc = c;

        while (true) {
            int tr = nr + dr[dir];
            int tc = nc + dc[dir];
            char cell = board[tr][tc];
            if (cell == '#') break;
            nr = tr; nc = tc; steps++;
            if (cell == 'O') {
                return new int[]{nr, nc, steps, 1};
            }
        }
        return new int[]{nr, nc, steps, 0};
    }

    static int bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[n][m][n][m];

        dq.offer(new int[]{beads[0], beads[1], beads[2], beads[3], 0});
        visited[beads[0]][beads[1]][beads[2]][beads[3]] = true;

        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            if (now[4] >= 10) continue;

            for (int dir = 0; dir < 4; dir++) {
                int[] r = roll(now[0], now[1], dir);
                int[] b = roll(now[2], now[3], dir);

                if (b[3] == 1) continue;
                if (r[3] == 1) return now[4] + 1;

                int nrr = r[0], nrc = r[1], nbr = b[0], nbc = b[1];

                if (nrr == nbr && nrc == nbc) {
                    if (r[2] > b[2]) {
                        nrr -= dr[dir];
                        nrc -= dc[dir];
                    } else {
                        nbr -= dr[dir];
                        nbc -= dc[dir];
                    }
                }

                if (!visited[nrr][nrc][nbr][nbc]) {
                    visited[nrr][nrc][nbr][nbc] = true;
                    dq.offer(new int[]{nrr, nrc, nbr, nbc, now[4] + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        beads = new int[4];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'O') {
                    hr = i; hc = j;
                } else if (board[i][j] == 'R') {
                    beads[0] = i; beads[1] = j;
                } else if (board[i][j] == 'B') {
                    beads[2] = i; beads[3] = j;
                }
            }
        }

        System.out.println(bfs());
    }
}