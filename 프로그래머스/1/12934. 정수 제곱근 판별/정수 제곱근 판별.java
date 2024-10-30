class Solution {
    public long solution(long n) {
        long answer = 0, num = 1;
        
        while (num <= Math.sqrt(n)) {
            if (Math.pow(num, 2) == n) {
                return answer = (long)Math.pow(num + 1, 2);
            }
            num++;
        }
        return -1;
    }
}