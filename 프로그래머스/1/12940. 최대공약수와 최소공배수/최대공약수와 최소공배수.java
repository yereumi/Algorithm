class Solution {
    public int[] solution(int n, int m) {
        int min, gcd = 1, lcm = 2;
        
        if (n < m) {
            min = n;
        } else {
            min = m;
        }
        
        for (int i = 1; i <= min; i++) {
            if (n % i == 0 && m % i == 0) {
                gcd = i;
            }
        }
        
        for (int i = 2; i <= n * m; i++) {
            if (i % n == 0 && i % m == 0) {
                lcm = i;
                break;
            }
        }
        
        return new int[]{gcd, lcm};
    }
}