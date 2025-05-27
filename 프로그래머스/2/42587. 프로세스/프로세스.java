import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> dq = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < priorities.length; i++) {
            dq.offer(new int[] { i, priorities[i] });
            pq.offer(priorities[i]);
        }
        
        int answer = 0;
        while (true) {
            int[] now = dq.poll();
            
            if (pq.peek() == now[1]) {
                pq.poll();
                answer++;
                
                if (now[0] == location) {
                    break;
                }
            } else {
                dq.offer(now);
            }
        }
        return answer;
    }
}