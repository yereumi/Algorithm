import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int[][] students;
    static Map<Integer, Integer> map;

    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    static boolean isValid(int r, int c) {
        return r > 0 && r <= N && c > 0 && c <= N;
    }

    static void findSeat(int[] stu) {
        int cur = stu[0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] != o2[2]) return o2[2] - o1[2];
            if (o1[3] != o2[3]) return o2[3] - o1[3];
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                if (board[i][j] != 0) continue;

                int likeCnt = 0;
                int emptyCnt = 0;

                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if (!isValid(nr, nc)) continue;

                    if (board[nr][nc] == 0) {
                        emptyCnt++;
                    } else {
                        int neighbor = board[nr][nc];
                        for (int k = 1; k < 5; k++) {
                            if (stu[k] == neighbor) {
                                likeCnt++;
                                break;
                            }
                        }
                    }
                }

                pq.offer(new int[]{i, j, likeCnt, emptyCnt});
            }
        }

        int[] res = pq.poll();
        board[res[0]][res[1]] = cur;
    }

    static int satisfy() {
        int result = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int s = board[i][j];
                int idx = map.get(s);
                int cnt = 0;

                for (int p = 0; p < 4; p++) {
                    int nr = i + dr[p];
                    int nc = j + dc[p];

                    if (!isValid(nr, nc)) continue;

                    int neighbor = board[nr][nc];
                    for (int k = 1; k < 5; k++) {
                        if (students[idx][k] == neighbor) {
                            cnt++;
                            break;
                        }
                    }
                }
                result += Math.pow(10, cnt - 1);
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        students = new int[N * N + 1][5];
        map = new HashMap<>();
        StringTokenizer st;

        for (int i = 1; i <= N * N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                students[i][j] = Integer.parseInt(st.nextToken());
            }
            map.put(students[i][0], i);
            findSeat(students[i]);
        }

        System.out.println(satisfy());
    }
}
