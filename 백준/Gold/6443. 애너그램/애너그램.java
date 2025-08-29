import java.util.*;
import java.io.*;

public class Main {
	
	static int len;
	static int[] ab, used;
	
	static void backtracking(int cnt, String word) {
		if (cnt == len) {
			System.out.println(word);
			return;
		}
		
		for (int i = 0; i < 26; i++) {
			if (ab[i] != 0 && ab[i] > used[i]) {
				used[i]++;
				backtracking(cnt + 1, word + (char)('a' + i));
				used[i]--;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			len = word.length();
			ab = new int[26];
			used = new int[26];
			for (int j = 0; j < len; j++) {
				char c = word.charAt(j);
				ab[c - 'a']++;
			}
			backtracking(0, "");
		}
	}
}