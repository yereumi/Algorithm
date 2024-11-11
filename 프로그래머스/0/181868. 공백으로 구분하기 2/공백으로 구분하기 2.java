import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> answer = new ArrayList<>();
        String result = "";
        my_string.trim().split(" ");
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) == ' ' && !result.equals("")) {
                answer.add(result);
                result = "";
            } else if (my_string.charAt(i) != ' ') {
                result += my_string.charAt(i);
            }
        }
        if (!result.equals(""))
        	answer.add(result);
        return answer.toArray(new String[answer.size()]);
    }
}