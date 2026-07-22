class Solution {
    public int[] solution(int[] num_list) {
        int even = 0, odd = 0;
        
        for (int i : num_list) {
            if (i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        int[] answer = {even, odd};
        
        return answer;
    }
}