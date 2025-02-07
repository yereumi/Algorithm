import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> result = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
            	if (i != j) result.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = result.stream()
        		.mapToInt(i -> i)
        		.toArray();
        return answer;
    }
}