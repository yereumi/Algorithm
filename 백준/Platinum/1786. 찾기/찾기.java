import java.util.*;
import java.io.*;

public class Main {
	
	static String t, p;
	static int[] table;

	public static void kmp() {
		int j = 0;
		for (int i = 1; i < p.length(); i++) {
			while (j > 0 && p.charAt(i) != p.charAt(j)) {
				j = table[j - 1];
			}
			if (p.charAt(i) == p.charAt(j)) {
				table[i] = ++j;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		t = br.readLine();
		p = br.readLine();
		table = new int[p.length()];
		kmp();
		List<Integer> result = new ArrayList<>();
		int j = 0;
		for (int i = 0; i < t.length(); i++) {
			while (j > 0 && t.charAt(i) != p.charAt(j)) {
                j = table[j - 1];
            }
            if (t.charAt(i) == p.charAt(j)) {
                if (j == p.length() - 1) { 
                    result.add(i - p.length() + 2);
                    j = table[j];
                } else {
                    j++;
                }
            }
		}
		sb.append(result.size()).append("\n");
		for (int i : result) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
