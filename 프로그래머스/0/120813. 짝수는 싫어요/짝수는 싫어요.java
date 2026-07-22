import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for (int i = 1; i < n + 1; i = i + 2) {
            arrayList.add(i);
        }
        
        int[] answer = arrayList.stream().mapToInt(x -> x).toArray();
        
        return answer;
    }
}