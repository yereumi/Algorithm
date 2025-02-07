import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] std1 = new int[] { 1, 2, 3, 4, 5 };
        int[] std2 = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] std3 = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        int[] ans = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (std1[i % 5] == answers[i]) ans[0]++;
            if (std2[i % 8] == answers[i]) ans[1]++;
            if (std3[i % 10] == answers[i]) ans[2]++;
        }
        int maxScore = Arrays.stream(ans).max().getAsInt();
        List<Integer> totalList = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == maxScore) totalList.add(i + 1);
        }
        Collections.sort(totalList);
        return totalList.stream().mapToInt(i -> i).toArray();
    }
}