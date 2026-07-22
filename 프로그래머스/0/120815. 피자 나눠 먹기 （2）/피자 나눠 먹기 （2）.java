import java.util.*;

class Solution {
    public int solution(int n) {
        // 최대공약수를 구한 후 n에서 나누기
        int smaller = n > 6 ? 6 : n;
        int greater = n > 6 ? n : 6;
        int r = greater % smaller;
        
        while (r != 0) {
            greater = smaller;
            smaller = r;
            
            r = greater % smaller;
        }
        
        return n / smaller;
    }
}