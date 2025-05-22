import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        int cnt = 0;
        while (true) {
            if (pq.size() != 0 && pq.peek() >= K) break;
            if (pq.size() == 1) {
                cnt = -1;
                break;
            }
            pq.offer(pq.poll() + pq.poll() * 2);
            cnt++;
        }
        return cnt;
    }
}