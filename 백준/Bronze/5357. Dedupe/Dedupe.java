import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			char prev = str.charAt(0);
			sb.append(prev);
			for (int j = 1; j < str.length(); j++) {
				if (prev != str.charAt(j)) {
					prev = str.charAt(j);
					sb.append(prev);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}