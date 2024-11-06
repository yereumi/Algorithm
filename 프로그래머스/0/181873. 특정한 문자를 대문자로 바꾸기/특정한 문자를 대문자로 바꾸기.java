class Solution {
    public String solution(String my_string, String alp) {
        return my_string.replace(alp, (char) (alp.charAt(0) - 'a' + 'A') + "");
    }
}