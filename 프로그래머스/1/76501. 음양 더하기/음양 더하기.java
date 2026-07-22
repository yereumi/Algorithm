class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0, sign = 1;
        
        for (int i = 0; i < absolutes.length; i++) {
            sign = 1;
            if (!signs[i]) {
                sign *= (-1);
            }
            answer += sign * absolutes[i];
        }
        return answer;
    }
}