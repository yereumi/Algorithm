import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
       Deque<Integer> deque = new ArrayDeque<>();
        int[] answer;
        for (int i : num_list) {
            deque.addLast(i);
        }
        for (int i = 0; i < n; i++) {
            int num = deque.removeFirst();
            deque.addLast(num);
        }
        answer = new int[deque.size()];
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = deque.removeFirst();
        }
        return answer;
    }
}