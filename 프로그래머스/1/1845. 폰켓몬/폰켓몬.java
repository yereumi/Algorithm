import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> pocketmons = new HashMap<>();
		for (int i : nums) {
			pocketmons.put(i, pocketmons.getOrDefault(0, i) + 1);
		}
		int num = nums.length / 2;
		
		if (num <= pocketmons.size()) {
			return num;
		}
		return pocketmons.size();
    }
}