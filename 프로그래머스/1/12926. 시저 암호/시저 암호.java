import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
            	int num = (s.charAt(i) - 'a' + n) % 26;
            	sb.append((char)('a' + num));
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
            	int num = (s.charAt(i) - 'A' + n) % 26;
            	sb.append((char)('A' + num));
            } else {
            	sb.append(Character.toString(s.charAt(i)));
            }
        }
        return sb.toString();
    }
}