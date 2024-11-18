class Solution {
    public static int[] solution(String s) {
		int cnt = 0;
		int num = 0;
		while (!s.equals("1")) {
			cnt++;
			num += s.split("0", -1).length - 1;
			s = s.replaceAll("0", "");
			int s_len = s.length();
			s = Integer.toBinaryString(s_len);
		}
		return new int[] { cnt, num };
	}
}