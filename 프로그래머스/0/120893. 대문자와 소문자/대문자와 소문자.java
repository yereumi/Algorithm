import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.insert(i, Character.toUpperCase(c));
            } else if (c >= 'A' && c <= 'Z') {
                sb.insert(i, Character.toLowerCase(c));
            }
        }
        System.out.println(sb);
        return sb.toString();
    }
}