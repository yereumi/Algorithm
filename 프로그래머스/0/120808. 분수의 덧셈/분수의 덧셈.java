import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int n1 = denom1, n2 = denom2;
        
        numer1 *= n2;
        denom1 *= n2;
        numer2 *= n1;
        denom2 *= n1;
        
        int numer = numer1 + numer2;
        int denom = denom1;
        
        for (int i = 2; i < denom; i++) {
            while (numer % i == 0 && denom % i == 0) {
                numer /= i;
                denom /= i;
            }
        }
        
        return new int[] {numer, denom};
    }
}