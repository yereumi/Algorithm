import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] board; // 0: 빈 공간, 1: 치즈, -1: 외부 공기
    static int[][] visited; // visited[r][c] == currentTime 이면 방문한 것
    static int currentTime = 1;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    static void checkOutAir(int r, int c) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{r, c});
        board[r][c] = -1;
        visited[r][c] = currentTime;

        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if (isValid(nr, nc) && visited[nr][nc] != currentTime && board[nr][nc] == 0) {
                    board[nr][nc] = -1;
                    visited[nr][nc] = currentTime;
                    dq.offer(new int[]{nr, nc});
                }
            }
        }
    }

    static boolean checkMeltCheese() {
        List<int[]> meltList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (isValid(nr, nc) && board[nr][nc] == -1) cnt++;
                    }
                    if (cnt >= 2) meltList.add(new int[]{i, j});
                }
            }
        }

        if (meltList.isEmpty()) return false;

        for (int[] pos : meltList) {
            int r = pos[0], c = pos[1];
            board[r][c] = -1;
            currentTime++;
            checkOutAir(r, c);
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkOutAir(0, 0);

        int time = 0;
        while (true) {
            if (!checkMeltCheese()) break;
            time++;
        }

        System.out.println(time);
    }
}
