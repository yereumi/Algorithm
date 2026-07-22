import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        List<String> strList = new ArrayList<>(Arrays.asList(s1));
        for (String str : s2) {
            if (strList.contains(str))
                answer++;
        }    
            
        return answer;
    }
}