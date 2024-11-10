import java.util.*;

class Solution {
    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6)
            return false;
        try {
            Integer n = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}