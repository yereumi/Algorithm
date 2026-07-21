import java.util.*;

class Solution {
    
    static List<Set<Integer>> dp;
    static Set<Integer> current;
    
    static Set<Integer> solve(int a, int b) {
        Set<Integer> setA = dp.get(a);
        Set<Integer> setB = dp.get(b);
        Set<Integer> result = new HashSet<>();
        
        for (int sa : setA) {
            for (int sb : setB) {
                result.add(sa + sb);
                result.add(sa - sb);
                result.add(sa * sb);
                if (sb != 0) result.add(sa / sb);
            }
        }
        
        current.addAll(result);
        
        return result;
    }
    
    public static int solution(int N, int number) {
        int answer = 0;
        
        dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        current = new HashSet<>();
        
        for (int i = 1; i <= 8; i++) {
            int num = 0;
            for (int j = 0; j < i; j++) {
                num *= 10;
                num += N;
            }
            dp.get(i).add(num);
            current.add(num);
            
            for (int j = 1; j < i; j++) {
                dp.get(i).addAll(solve(j, i - j));
            }
            
            if (current.contains(number)) return i;
        }
        
        return -1;
    }
}
