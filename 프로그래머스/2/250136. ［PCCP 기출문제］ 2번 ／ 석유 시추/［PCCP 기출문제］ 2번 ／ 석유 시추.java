import java.util.*;

class Solution {
    
    static int landR, landC;
    static Map<Integer, Integer> oilList;
    static int[][] Land;
    static int[] dy = new int[] { 1, -1, 0, 0 };
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static Map<Integer, Set<Integer>> columnToGroups;
    
    static boolean isValid(int r, int c) {
        return r >= 0 && r < landR && c >= 0 && c < landC;
    }
    
    static int oil(int r, int c, int num) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { r, c });
        Land[r][c] = num;
        int cnt = 1;

        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            int row = now[0], col = now[1];

            columnToGroups.computeIfAbsent(col, k -> new HashSet<>()).add(num);

            for (int i = 0; i < 4; i++) {
                int nr = row + dy[i], nc = col + dx[i];
                if (isValid(nr, nc) && Land[nr][nc] == 1) {
                    Land[nr][nc] = num;
                    dq.offer(new int[] { nr, nc });
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void calculateOil() {
        int num = 2;
        for (int i = 0; i < landR; i++) {
            for (int j = 0; j < landC; j++) {
                if (Land[i][j] == 1) {
                    oilList.put(num, oil(i, j, num));
                    num++;
                }
            }
        }
    }

    static int findMaxOil() {
        int maxOil = 0;

        for (int col = 0; col < landC; col++) {
            int oilSize = 0;
            Set<Integer> groupSet = columnToGroups.getOrDefault(col, Collections.emptySet());
            for (int group : groupSet) {
                oilSize += oilList.get(group);
            }
            maxOil = Math.max(maxOil, oilSize);
        }

        return maxOil;
    }
    
    public static int solution(int[][] land) {
        landR = land.length;
        landC = land[0].length;
        Land = land;
        oilList = new HashMap<>();
        columnToGroups = new HashMap<>();

        calculateOil();
        return findMaxOil();
    }
}