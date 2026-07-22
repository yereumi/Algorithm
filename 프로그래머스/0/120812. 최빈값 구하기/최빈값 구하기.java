import java.util.*;

class Solution {
    public int solution(int[] array) {
        
        Map<Integer, Integer> counts = new HashMap<>();
        
        for (int n : array) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }
        
        int maxValue = Collections.max(counts.values());
        int maxNum = 0;
        int maxKey = 0;

        // 최빈값의 숫자와 그 빈도를 찾습니다.
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == maxValue) {
                maxNum++;
                maxKey = entry.getKey();
            }
        }
        
        // 최빈값이 하나가 아니라면 -1을 반환합니다.
        if (maxNum > 1) {
            return -1;
        }
        
        return maxKey;
    }
}