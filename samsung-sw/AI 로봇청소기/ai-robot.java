import java.io.*;
import java.util.*;

public class Main {

    static int N, K, L;
    static int[][] room;
    static Deque<int[]> robots;
    static boolean[][] visitedRobots;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static boolean isValid(int r, int c) {
        return r > 0 && r <= N && c > 0 && c <= N && room[r][c] != -1;
    }

    static void moveRobot() {
        for (int i = 0; i < K; i++) {
            Deque<int[]> dq = new ArrayDeque<>();
            boolean[][] visited = new boolean[N + 1][N + 1];

            int[] robot = robots.poll();
            visitedRobots[robot[0]][robot[1]] = false;
            dq.offer(new int[] { robot[0], robot[1] });
            visited[robot[0]][robot[1]] = true;

            boolean moved = false;

            while (!dq.isEmpty()) {
                int size = dq.size();

                int bestR = Integer.MAX_VALUE;
                int bestC = Integer.MAX_VALUE;
                boolean found = false;

                for (int s = 0; s < size; s++) {
                    int[] cur = dq.poll();
                    int r = cur[0];
                    int c = cur[1];

                    if (room[r][c] > 0) {
                        found = true;
                        if (r < bestR || (r == bestR && c < bestC)) {
                            bestR = r;
                            bestC = c;
                        }
                    }

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (!isValid(nr, nc)) continue;
                        if (visited[nr][nc]) continue;
                        if (visitedRobots[nr][nc]) continue;

                        visited[nr][nc] = true;
                        dq.offer(new int[] { nr, nc });
                    }
                }

                if (found) {
                    robots.offer(new int[] { bestR, bestC });
                    visitedRobots[bestR][bestC] = true;
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                robots.offer(new int[] { robot[0], robot[1] });
                visitedRobots[robot[0]][robot[1]] = true;
            }
        }
    }

    static void clean() {
        for (int i = 0; i < K; i++) {
            int[] robot = robots.poll();
            int r = robot[0];
            int c = robot[1];

            int bestDir = -1;
            int maxDust = -1;

            for (int d = 0; d < 4; d++) {
                int sum = 0;

                sum += Math.min(20, room[r][c]);

                int nr = r + dr[d];
                int nc = c + dc[d];
                if (isValid(nr, nc)) sum += Math.min(20, room[nr][nc]);

                int leftDir = (d + 3) % 4;
                nr = r + dr[leftDir];
                nc = c + dc[leftDir];
                if (isValid(nr, nc)) sum += Math.min(20, room[nr][nc]);

                int rightDir = (d + 1) % 4;
                nr = r + dr[rightDir];
                nc = c + dc[rightDir];
                if (isValid(nr, nc)) sum += Math.min(20, room[nr][nc]);

                if (sum > maxDust) {
                    maxDust = sum;
                    bestDir = d;
                }
            }

            cleanCell(r, c);

            int[] checkDirs = { bestDir, (bestDir + 3) % 4, (bestDir + 1) % 4 };

            for (int d : checkDirs) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (isValid(nr, nc)) {
                    cleanCell(nr, nc);
                }
            }

            robots.offer(robot);
        }
    }

    static void cleanCell(int r, int c) {
        room[r][c] -= 20;
        if (room[r][c] < 0) room[r][c] = 0;
    }

    static void addDust() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (room[i][j] > 0) room[i][j] += 5;
            }
        }
    }

    static void diffuse() {
        int[][] next = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (room[i][j] == 0) {
                    int sum = 0;

                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (!isValid(nr, nc)) continue;

                        sum += room[nr][nc];
                    }

                    next[i][j] = sum / 10;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (next[i][j] != 0) room[i][j] = next[i][j];
            }
        }
    }

    static void print() {
        int total = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (room[i][j] > 0) total += room[i][j];
            }
        }

        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        room = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visitedRobots = new boolean[N + 1][N + 1];
        robots = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            robots.offer(new int[] { r, c });
            visitedRobots[r][c] = true;
        }

        for (int i = 0; i < L; i++) {
            moveRobot();
            clean();
            addDust();
            diffuse();
            print();
        }

    }
}