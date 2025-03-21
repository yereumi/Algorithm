import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static char[][] lake;
    static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
    static Deque<int[]> swanQueue = new ArrayDeque<>(), nextSwanQueue = new ArrayDeque<>();
    static Deque<int[]> meltQueue = new ArrayDeque<>(), nextMeltQueue = new ArrayDeque<>();
    static boolean[][] swanVisited, meltVisited;
    static int[] swans;

    static boolean isValid(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    static void initialize(BufferedReader br) throws IOException {
        lake = new char[n][m];
        swanVisited = new boolean[n][m];
        meltVisited = new boolean[n][m];
        swans = new int[4];
        boolean foundFirstSwan = false;
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                lake[i][j] = line.charAt(j);
                
                if (lake[i][j] == 'L') {
                    if (!foundFirstSwan) {
                        swans[0] = i; swans[1] = j;
                        foundFirstSwan = true;
                    } else {
                        swans[2] = i; swans[3] = j;
                    }
                    lake[i][j] = '.';
                }
                
                if (lake[i][j] == '.') {
                    meltQueue.offer(new int[]{i, j});
                    meltVisited[i][j] = true;
                }
            }
        }
        swanQueue.offer(new int[]{swans[0], swans[1]});
        swanVisited[swans[0]][swans[1]] = true;
    }

    static boolean moveSwans() {
        while (!swanQueue.isEmpty()) {
            int[] now = swanQueue.poll();
            int y = now[0], x = now[1];
            
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d], nx = x + dx[d];
                if (isValid(ny, nx) && !swanVisited[ny][nx]) {
                    swanVisited[ny][nx] = true;
                    if (ny == swans[2] && nx == swans[3]) return true;
                    if (lake[ny][nx] == '.') swanQueue.offer(new int[]{ny, nx});
                    else nextSwanQueue.offer(new int[]{ny, nx});
                }
            }
        }
        return false;
    }

    static void meltIce() {
        while (!meltQueue.isEmpty()) {
            int[] now = meltQueue.poll();
            int y = now[0], x = now[1];
            
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d], nx = x + dx[d];
                if (isValid(ny, nx) && !meltVisited[ny][nx] && lake[ny][nx] == 'X') {
                    lake[ny][nx] = '.';
                    nextMeltQueue.offer(new int[]{ny, nx});
                    meltVisited[ny][nx] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        initialize(br);
        
        int days = 0;
        while (true) {
            if (moveSwans()) break;
            meltIce();
            swanQueue = new ArrayDeque<>(nextSwanQueue);
            meltQueue = new ArrayDeque<>(nextMeltQueue);
            nextSwanQueue.clear();
            nextMeltQueue.clear();
            days++;
        }
        System.out.println(days);
    }
}