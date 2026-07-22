class Solution {
    public int solution(String str1, String str2) {
        int len = str2.length();
        
        for (int i = 0; i < str1.length() - len + 1; i++) {
            String newString = str1.substring(i, i + len);
            if (newString.equals(str2))
                return 1;
        }
        
        return 2;
    }
}