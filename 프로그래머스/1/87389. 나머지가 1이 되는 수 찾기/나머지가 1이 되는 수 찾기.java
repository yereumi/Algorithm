class Solution {
    public int solution(int n) {
        int answer = 2;
        while ((n - 1) % answer != 0) {
            answer++;
        }
        return answer;
    }
}