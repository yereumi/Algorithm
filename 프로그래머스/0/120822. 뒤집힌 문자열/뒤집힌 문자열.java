class Solution {
    public String solution(String my_string) {
        
        char[] new_char = new char[my_string.length()];
        
        for (int i = 0; i < my_string.length(); i++) {
            new_char[i] = my_string.charAt(my_string.length() - 1 - i);
        }
        
        return new String.valueOf(new_char);
        
    }
}