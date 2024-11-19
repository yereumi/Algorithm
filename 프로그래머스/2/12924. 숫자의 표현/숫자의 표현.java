class Solution {
    public int solution(int n) {
        int cnt = 1;
		for (int i = 1; i < n / 2 + 1; i++) {
			int sum = 0;
			int num = i;
			while (sum < n) {
				sum += num;
				num++;
			}
			if (sum == n) cnt++;
		}
		return cnt;
    }
}