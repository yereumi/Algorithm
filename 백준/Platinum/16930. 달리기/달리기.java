import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k, y1, x1, y2, x2;
    static char[][] board;
    static int[][] time;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] time = new int[n + 1][m + 1];
        
        for (int[] row : time) Arrays.fill(row, Integer.MAX_VALUE); // 초기값 무한대
        time[y1][x1] = 0;
        dq.offer(new int[]{y1, x1});
        
        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            int y = now[0], x = now[1];

            if (y == y2 && x == x2) return time[y][x]; // 도착하면 종료
            
            for (int i = 0; i < 4; i++) {
                int ny = y, nx = x;

                for (int j = 1; j <= k; j++) {
                    ny += dy[i];
                    nx += dx[i];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) break; // 범위 초과
                    if (board[ny][nx] == '#') break; // 벽이면 중단

                    if (time[ny][nx] < time[y][x] + 1) break; // 이미 더 빠르게 방문한 경우 중단
                    
                    if (time[ny][nx] == Integer.MAX_VALUE) { // 처음 방문하는 경우
                        time[ny][nx] = time[y][x] + 1;
                        dq.offer(new int[]{ny, nx});
                    }
                }
            }
        }
        return -1; // 도달 불가능
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
        st = new StringTokenizer(br.readLine());
        y1 = Integer.parseInt(st.nextToken()) - 1;
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;
        x2 = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(bfs());
    }
}