import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        for (int i : queue1) sum1 += i;
        for (int i : queue2) sum2 += i;
        
        long total = sum1 + sum2;
        
        if (total % 2 != 0) return -1;
        long target = total / 2;
        
        int n = queue1.length;
        int i = 0, j = 0, cnt = 0;
        
        int[] arr = new int[n * 2];
        System.arraycopy(queue1, 0, arr, 0, n);
        System.arraycopy(queue2, 0, arr, n, n);

        while (cnt <= n * 3) {
            if (sum1 == target) return cnt;

            if (sum1 > target) {
                if (i < 2 * n) {
                    sum1 -= arr[i % (2 * n)];
                    i++;
                } else break;
            } else {
                if (j < 2 * n) {
                    sum1 += arr[(n + j) % (2 * n)];
                    j++;
                } else break;
            }

            cnt++;
        }

        return -1;
    }
}