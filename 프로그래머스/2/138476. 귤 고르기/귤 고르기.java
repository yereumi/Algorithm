import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        map.entrySet().forEach(entry -> pq.offer(new int[] { entry.getKey(), entry.getValue() }));
        
        int total = 0;
        int answer = 0;
        while (total < k) {
            int[] now = pq.poll();
            total += now[1];
            answer++;
        }
        
        return answer;
    }
}