import java.util.*;
import java.util.Collections.*;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Integer[] intB = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(intB, Collections.reverseOrder());
        
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * intB[i];
        }
        
        return answer;
    }
}