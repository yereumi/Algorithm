import java.io.*;
import java.util.*;

public class Main {

    static int N, Q;
    static Map<Integer, int[]> map; // 각 미생물의 경계 좌표 저장
    static int[][] board;
    static int[][] area;

    /**
     * 범위 내에 있는지 확인하는 함수
     */
    static boolean isValid(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    /**
    * 미생물 분리됐는지 확인할 때 bfs로 미생물 영역 탐색하는 함수
    */
    static void bfs(boolean[][] visited, int sr, int sc, int num) {
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { sr, sc });
        visited[sr][sc] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (!isValid(nr, nc)) continue;
                if (visited[nr][nc]) continue;
                if (board[nr][nc] != num) continue;
                visited[nr][nc] = true;
                dq.offer(new int[] { nr, nc });
            }
        }
    }

    /**
     * 미생물 투입하는 함수
     */
    static void add(int r1, int c1, int r2, int c2, int num) {
        // [r1, r2), [c1, c2) 영역에 num 주입 (기존 셀 잡아먹기)
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                if (board[i][j] != 0) {
                    int prev = board[i][j];
                    area[prev][1]--;
                }
                board[i][j] = num;
                area[num][1]++;
            }
        }
    }

    /**
     * 분리된 미생물 제거하는 함수
     */
    static void remove(int id) {
        if (!map.containsKey(id))
            return;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == id)
                    board[i][j] = 0;
            }
        }
        area[id][1] = 0;
        map.remove(id);
    }

    /**
     * 미생물 분리됐는지 확인하는 함수
     */
    static void checkDivide(int uptoId) {
        // 각 id에 대해 연결 컴포넌트 수 계산 → 0 또는 2개 이상이면 제거
        for (int id = 1; id <= uptoId; id++) {
            if (!map.containsKey(id))
                continue;

            boolean[][] visited = new boolean[N][N];
            int comp = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && board[i][j] == id) {
                        bfs(visited, i, j, id);
                        comp++;
                        if (comp > 1) break;
                    }
                }
                if (comp > 1) break;
            }

            if (comp == 0 || comp > 1) {
                remove(id);
            }
        }
    }

    /**
     * 배양 용기 이동하는 함수
     */
    static void move(int maxId) {
        // 1) 현재 board를 스캔해서 각 군집의 최신 크기와 경계 박스 재계산
        int[] size = new int[Q + 1];
        int[][] bound = new int[Q + 1][4]; // {minR, minC, maxR, maxC}
        for (int id = 0; id <= Q; id++) {
            bound[id][0] = bound[id][1] = Integer.MAX_VALUE;
            bound[id][2] = bound[id][3] = -1;
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int id = board[r][c];
                if (id == 0) continue;
                size[id]++;
                if (r < bound[id][0]) bound[id][0] = r;
                if (c < bound[id][1]) bound[id][1] = c;
                if (r > bound[id][2]) bound[id][2] = r;
                if (c > bound[id][3]) bound[id][3] = c;
            }
        }
        // area 동기화 (result()에서 사용)
        for (int id = 1; id <= Q; id++) {
            area[id][1] = size[id];
        }

        // 2) 존재하는 군집만 모아서 (크기 내림차순, id 오름차순) 정렬
        List<int[]> list = new ArrayList<>(); // {id, size}
        for (int id = 1; id <= maxId; id++) {
            if (size[id] > 0) list.add(new int[] { id, size[id] });
        }
        list.sort((x, y) -> {
            if (x[1] != y[1]) return y[1] - x[1]; // 크기 내림차순
            return x[0] - y[0]; // id 오름차순
        });

        // 3) 새 보드에 최좌상(행, 그 다음 열) 위치부터 배치
        int[][] newBoard = new int[N][N];

        for (int[] e : list) {
            int id = e[0];
            int minR = bound[id][0], minC = bound[id][1];
            int maxR = bound[id][2], maxC = bound[id][3];
            // 이미 제거되었거나 정보 없음 방지
            if (minR == Integer.MAX_VALUE) continue;

            int h = maxR - minR + 1;
            int w = maxC - minC + 1;

            outer: for (int r = 0; r + h <= N; r++) {
                for (int c = 0; c + w <= N; c++) {
                    // **모양 기준** 충돌 검사: 원래 board에서 id인 칸만 검사
                    boolean canPlace = true;
                    for (int dr = 0; dr < h && canPlace; dr++) {
                        for (int dc = 0; dc < w; dc++) {
                            int or = minR + dr, oc = minC + dc;
                            if (board[or][oc] != id) continue; // 군집 셀 아니면 스킵
                            if (newBoard[r + dr][c + dc] != 0) { // 겹치면 불가
                                canPlace = false;
                                break;
                            }
                        }
                    }
                    if (canPlace) {
                        // 실제 배치: 군집 셀에 한해서만 평행 이동 복사
                        int offR = r - minR, offC = c - minC;
                        for (int i = 0; i < N; i++) {
                            for (int j = 0; j < N; j++) {
                                if (board[i][j] == id) {
                                    newBoard[i + offR][j + offC] = id;
                                }
                            }
                        }
                        // 새 경계 박스 갱신
                        map.put(id, new int[] { r, c, r + h, c + w });
                        break outer;
                    }
                }
            }
        }

        // 4) 보드 교체
        for (int i = 0; i < N; i++) {
            System.arraycopy(newBoard[i], 0, board[i], 0, N);
        }
    }

    static int result() {
        int sum = 0;
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        Set<Long> seen = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int a = board[i][j];
                if (a == 0) continue;
                for (int d = 0; d < 4; d++) {
                    int ni = i + dr[d], nj = j + dc[d];
                    if (!isValid(ni, nj)) continue;
                    int b = board[ni][nj];
                    if (b == 0 || a == b) continue;

                    int x = Math.min(a, b), y = Math.max(a, b);
                    long key = ((long) x << 32) | (long) y;
                    if (seen.add(key)) {
                        sum += area[x][1] * area[y][1];
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        board = new int[N][N];
        area = new int[Q + 1][2];
        for (int i = 1; i <= Q; i++) area[i][0] = i;

        for (int id = 1; id <= Q; id++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            // 초기 경계 박스는 주입 직사각형 (이후 move에서 매번 재계산)
            map.put(id, new int[] { r1, c1, r2, c2 });

            add(r1, c1, r2, c2, id); // 주입(잡아먹기 포함)
            checkDivide(id); // 분리된 군집 제거
            move(id); // 군집 이동(최좌상 배치)
            System.out.println(result()); // 인접 군집 쌍 점수
        }
    }
}
