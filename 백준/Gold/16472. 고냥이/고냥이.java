import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int[] cnt = new int[26];
		int left = 0, right = 0;
		int distinct = 0;
		int max = 0;
		
		while (left < str.length() && right < str.length()) {
			int idx = str.charAt(right) - 'a';
			
			if (cnt[idx] == 0) {
				cnt[idx] = 1;
				distinct++;
			} else {
				cnt[idx]++;
			}
			
			if (distinct > n) {
				while (distinct > n) {
					idx = str.charAt(left) - 'a';
					cnt[idx]--;
					if (cnt[idx] == 0) distinct--;
					left++;
				}
			}
			max = Math.max(max, right - left + 1);
			
			right++;
		}
		
		System.out.println(max);
	}
}
