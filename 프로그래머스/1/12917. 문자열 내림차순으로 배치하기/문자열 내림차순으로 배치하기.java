import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] array = s.split("");
        List<String> list = Arrays.asList(array);
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }
        return answer;
    }
}