import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String s1 = br.readLine();
		 String s2 = br.readLine();
		 int[][] lcs = new int[s1.length() + 1][s2.length() + 1];
		 for (int i = 1; i <= s1.length(); i++) {
			 for (int j = 1; j <= s2.length(); j++) {
				 if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					 lcs[i][j] = lcs[i - 1][j - 1] + 1;
					 } else {
					 lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				 }
			 }
		 }
		 int len = lcs[s1.length()][s2.length()];
		 System.out.println(len);
		 StringBuilder sb = new StringBuilder();
		 int i = s1.length(), j = s2.length();
		 while (i != 0 && j != 0 && len != 0) {
			 if (lcs[i][j] == len) {
				 if (lcs[i - 1][j] == len) {
					 i--;
				 } else if (lcs[i][j - 1] == len) {
					 j--;
				 } else if (lcs[i - 1][j] == len - 1 && lcs[i][j - 1] == len - 1) {
					 sb.append(s1.charAt(i - 1));
					 len--;
					 i--;
					 j--;
				 }
			 }
		 }
		 System.out.println(sb.reverse());
	}
}
