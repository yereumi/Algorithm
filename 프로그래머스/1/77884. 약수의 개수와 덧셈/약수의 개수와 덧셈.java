class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            answer = isDivisorEven(i) ? answer + i : answer - i;
        }
        return answer;
    }
    
    public boolean isDivisorEven(int num) {
        int count = 0;
        
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                count++;
        }
        
        return count % 2 == 0 ? true : false;
    }
}