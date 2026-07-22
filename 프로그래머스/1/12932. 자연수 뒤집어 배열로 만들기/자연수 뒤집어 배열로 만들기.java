class Solution {
    public int[] solution(long n) {
        long tmp = n;
        int size = 0, idx = 0;
        
        while (tmp > 0) {
            size++;
            tmp /= 10;
        }
        
        int[] answer = new int[size];
        
        while (n > 0) {
            answer[idx] = (int)(n % 10L);
            n /= 10;
            idx++;
        }
        
        return answer;
    }
}