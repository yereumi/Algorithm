class Solution {
    public int solution(int n) {
        return Integer.parseInt(new StringBuffer(Integer.toString(n, 3)).reverse().toString(), 3);
    }
}