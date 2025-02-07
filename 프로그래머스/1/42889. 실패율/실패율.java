import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] challenger = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]]++;
        }
        double total = stages.length;
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) map.put(i, 0.0);
        	else {
                map.put(i, challenger[i] / total);
        	    total -= challenger[i];
            }
        }
        return map.entrySet().stream()
        		.sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
        		.mapToInt(HashMap.Entry::getKey).toArray();
    }
}