import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			String num = br.readLine();
			int answer = 0;
			char z = '0';
			for (int j = 0; j < num.length(); j++) {
				if (num.charAt(j) != z) {
					answer++;
					z = num.charAt(j);
				}
			}
			System.out.println("#" + i + " " + answer);
		}
	}
}