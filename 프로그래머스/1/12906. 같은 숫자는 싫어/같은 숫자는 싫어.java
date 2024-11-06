import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        Stack<Integer> stackInt = new Stack<>();
        
        for (int i : arr) {
            if (stackInt.isEmpty()) {
                stackInt.push(i);
            }
            else if (stackInt.peek() != i) {
                stackInt.push(i);
            }
        }
        
        answer = new int[stackInt.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stackInt.get(i);
        }
        return answer;
    }
}