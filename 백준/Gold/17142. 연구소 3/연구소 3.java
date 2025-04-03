import java.util.*;
import java.io.*;

public class Main {
    static int n, m, minTime = Integer.MAX_VALUE;
    static int[][] lab;
    static List<int[]> virus;
    static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
    static boolean isPossible = false;

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    static boolean isValid(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    static void selectVirus(int depth, int idx, List<int[]> selected) {
        if (depth == m) {
            spread(selected);
            return;
        }
        for (int i = idx; i < virus.size(); i++) {
            selected.add(virus.get(i));
            selectVirus(depth + 1, i + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    static void spread(List<int[]> activeVirus) {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        int[][] time = new int[n][n];
        for (int[] row : time) Arrays.fill(row, -1);

        for (int[] v : activeVirus) {
        	dq.offer(new int[] { v[0], v[1], 0 });
            visited[v[0]][v[1]] = true;
            time[v[0]][v[1]] = 0;
        }

        int maxTime = 0;
        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            int y = now[0], x = now[1], t = now[2];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d], nx = x + dx[d];

                if (isValid(ny, nx) && !visited[ny][nx] && lab[ny][nx] != 1) {
                    visited[ny][nx] = true;
                    time[ny][nx] = t + 1;
                    dq.offer(new int[] { ny, nx, t + 1 });
                    if (lab[ny][nx] == 0) maxTime = Math.max(maxTime, t + 1);
                }
            }
        }

        if (checkSpread(time)) {
            isPossible = true;
            minTime = Math.min(minTime, maxTime);
        }
    }

    static boolean checkSpread(int[][] time) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lab[i][j] == 0 && time[i][j] == -1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        lab = new int[n][n];
        virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lab[i][j] = read();
                if (lab[i][j] == 2) virus.add(new int[] { i, j });
            }
        }

        selectVirus(0, 0, new ArrayList<>());
        System.out.println(isPossible ? minTime : -1);
    }
}