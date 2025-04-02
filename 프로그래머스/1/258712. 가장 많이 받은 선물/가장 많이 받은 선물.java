import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for (String str : friends) {
            map.put(str, idx++);
        }
        int n = friends.length;
        int[][] table = new int[n][n];
        for (String str : gifts) {
            StringTokenizer st = new StringTokenizer(str);
            String from = st.nextToken();
            String to = st.nextToken();
            int fromIdx = map.get(from);
            int toIdx = map.get(to);
            table[fromIdx][toIdx]++;
        }
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            int give = 0, receive = 0;
            for (int j = 0; j < n; j++) {
                give += table[i][j];
                receive += table[j][i];
            }
            index[i] = give - receive;
        }
        int[] newGift = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (table[i][j] > table[j][i]) {
                    newGift[i]++;
                } else if (table[i][j] < table[j][i]) {
                    newGift[j]++;
                } else {
                    if (index[i] > index[j]) {
                        newGift[i]++;
                    } else if (index[i] < index[j]) {
                        newGift[j]++;
                    }
                }
            }
        }
        int maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxCnt = Math.max(maxCnt, newGift[i] / 2);
        }
        return maxCnt;
    }
}