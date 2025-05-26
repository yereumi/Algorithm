import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static char[][] board;
    static int[] start;
    static boolean[][][][] visited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static List<int[]> delivery = new ArrayList<>();

    static boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    static int bfs() {
        visited = new boolean[n][m][4][4];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { start[0], start[1], 0, -1, 0 }); // r, c, dist, prevDir, deliverMask

        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            int r = now[0], c = now[1], dist = now[2], prevDir = now[3], mask = now[4];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (!isValid(nr, nc)) continue;
                if (board[nr][nc] == '#') continue;
                if (d == prevDir) continue;

                int nextMask = mask;

                for (int k = 0; k < delivery.size(); k++) {
                    int[] cpos = delivery.get(k);
                    if (nr == cpos[0] && nc == cpos[1]) {
                        nextMask |= (1 << k);
                    }
                }

                if (nextMask == 3) return dist + 1;

                if (!visited[nr][nc][d][nextMask]) {
                    visited[nr][nc][d][nextMask] = true;
                    dq.offer(new int[] { nr, nc, dist + 1, d, nextMask });
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        start = new int[2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (board[i][j] == 'C') {
                    delivery.add(new int[] { i, j });
                }
            }
        }

        System.out.println(bfs());
    }
}