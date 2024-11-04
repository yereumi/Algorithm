import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int min =  Arrays.stream(arr).min().getAsInt();
        if (arr.length != 1) {
            return Arrays.stream(arr)
                .filter(n -> n != min)
                .toArray();
        }
        return new int[]{-1};
    }
}