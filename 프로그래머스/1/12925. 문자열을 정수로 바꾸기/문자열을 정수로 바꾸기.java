class Solution {
    public int solution(String s) {
        int answer = 0;
        int sign = 1;
        
        for (int i = 0; i < s.length(); i++) {
            char num = s.charAt(i);
            answer *= 10;
            if (num == '-') {
                sign = -1;
            } else if (num == '+') {
                continue;
            } else {
                answer += num - '0';
            }
        }
        return answer * sign;
    }
}