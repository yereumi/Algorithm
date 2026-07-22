import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> arrayList = new ArrayList();
        
        for (int i : numlist) {
            if (i % n == 0) {
                arrayList.add(i);
            }
        }
        
        return arrayList.stream().mapToInt(x -> x).toArray();
    }
}