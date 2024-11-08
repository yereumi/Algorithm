import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        for (int i : arr) {
            if (i >= 50 && i % 2 == 0) {
                answer.add(i / 2);
            } else if (i < 50 && i % 2 == 1) {
                answer.add(i * 2);
            } else {
                answer.add(i);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}