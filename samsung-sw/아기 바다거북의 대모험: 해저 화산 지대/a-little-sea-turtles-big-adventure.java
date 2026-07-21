import java.io.*;
import java.util.*;

public class Main {
    
    public static int MAX_TURN = 100;
    public static int N, M, K, t;
    public static int[] time;
    public static int[][] board;
    public static int[][] turtle;
    public static int[][] volcano;
    public static boolean[] fossilization;

    public static int[] dr = { 0, 1, 0, -1 };
    public static int[] dc = { 1, 0, -1, 0 };

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    // 바다거북 이동
    public static void step1() {
        for (int i = 0; i < M; i++) {
            if (fossilization[i]) continue; // 화석화

            int sr = turtle[i][0], sc = turtle[i][1];
            
            int d = checkShortestPath(sr, sc);
            if (d == -1) continue;
            
            int nr = sr + dr[d];
            int nc = sc + dc[d];

            board[sr][sc] = 0;
            board[nr][nc] = 2;
            turtle[i][0] = nr;
            turtle[i][1] = nc;

            if (nr == N - 1 && nc == N - 1) {
                time[i] = t;
                board[nr][nc] = 0;
            }
        }
    }

    public static int checkShortestPath(int r, int c) {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        dq.offer(new int[] { r, c, -1 });
        visited[r][c] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();

            if (cur[0] == N - 1 && cur[1] == N - 1) {
                return cur[2];
            }

            for (int j = 0; j < 4; j++) {
                int nr = cur[0] + dr[j];
                int nc = cur[1] + dc[j];

                if (!isValid(nr, nc)) continue;
                if (board[nr][nc] != 0 || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                if (cur[2] == -1) dq.offer(new int[] { nr, nc, j });
                else dq.offer(new int[] { nr, nc, cur[2] });
            }
        }
        
        return -1;
    }

    // 화산 압력 증가
    public static void step2() {
        for (int i = 0; i < K; i++) {
            volcano[i][3] += 10;
        }
    }

    // 화산 분출 및 연쇄 반응
    // 1. 열기 전파
    // 2. 연쇄 반응
    // 3. 바다거북의 위기(화석화)
    public static void step3_4() {
        int[][] heat = new int[N][N];
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[K];

        for (int i = 0; i < K; i++) {
            if (volcano[i][3] < volcano[i][2]) continue;
            dq.offer(new int[] { volcano[i][0], volcano[i][1], volcano[i][2], -1 });
            heat[volcano[i][0]][volcano[i][1]] = volcano[i][2];
            visited[i] = true;
        }
        
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            
            if (cur[3] != -1) {
                int nr = cur[0] + dr[cur[3]];
                int nc = cur[1] + dc[cur[3]];
                int nh = cur[2] / 2;
                
                if (!isValid(nr, nc)) continue;
                if (board[nr][nc] == 1 || nh == 0) continue;
                
                heat[nr][nc] += nh;
                dq.offer(new int[] { nr, nc, nh, cur[3] });
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                int nh = cur[2] / 2;

                if (!isValid(nr, nc)) continue;
                if (board[nr][nc] == 1 || nh == 0) continue;

                heat[nr][nc] += nh;
                dq.offer(new int[] { nr, nc, nh, i });
            }

            for (int i = 0; i < K; i++) {
                if (visited[i]) continue;
                if (volcano[i][3] + heat[volcano[i][0]][volcano[i][1]] >= volcano[i][2]) {
                    dq.offer(new int[] { volcano[i][0], volcano[i][1], volcano[i][2], -1 });
                    heat[volcano[i][0]][volcano[i][1]] += volcano[i][2];
                    visited[i] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            if (time[i] != -1) continue;
            if (heat[turtle[i][0]][turtle[i][1]] >= 20) {
                fossilization[i] = true;
                board[turtle[i][0]][turtle[i][1]] = 3;
            }
        }

        // 환경 초기화
        for (int i = 0; i < K; i++) {
            if (visited[i]) {
                volcano[i][3] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][N]; // 0: 빈 공간, 1: 산호초, 2: 바다거북, 3: 화석화된 바다거북
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        turtle = new int[M][2]; // r, c
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            turtle[i][0] = Integer.parseInt(st.nextToken());
            turtle[i][1] = Integer.parseInt(st.nextToken());
            board[turtle[i][0]][turtle[i][1]] = 2;
        }
        fossilization = new boolean[M];

        volcano = new int[K][4]; // r, c, 분출 임계치 P, 마그마 압력(초기: 0)
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            volcano[i][0] = Integer.parseInt(st.nextToken());
            volcano[i][1] = Integer.parseInt(st.nextToken());
            volcano[i][2] = Integer.parseInt(st.nextToken());
        }

        time = new int[M];
        Arrays.fill(time, -1);
        t = 0;
        while (true) {
            if (t++ > MAX_TURN) break;
            step1();
            step2();
            step3_4();
        }

        StringBuilder sb = new StringBuilder();
        for (int t : time) {
            sb.append(t).append('\n');
        }

        System.out.println(sb.toString());
    }
}
