import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int n = sizes.length;
		for (int i = 0; i < n; i++) {
			if (sizes[i][0] < sizes[i][1]) {
				int tmp = sizes[i][0];
				sizes[i][0] = sizes[i][1];
				sizes[i][1] = tmp;
			}
		}
		int maxX = sizes[0][0], maxY = sizes[0][1];
		for (int i = 0; i < n; i++) {
			if (sizes[i][0] > maxX) {
				maxX = sizes[i][0];
			}
			if (sizes[i][1] > maxY) {
				maxY = sizes[i][1];
			}
		}
//		System.out.println(maxX + " " + maxY);
		return maxX * maxY;
    }
}