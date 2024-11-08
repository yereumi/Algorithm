import java.util.*;

class Solution {
    public String solution(String s) {
        String[] array = s.split(" ");
		List<Integer> list = new ArrayList<>();
		for (String str : array) {
			list.add(Integer.parseInt(str));
		}
        return Collections.min(list).toString() + " " + Collections.max(list).toString();
    }
}