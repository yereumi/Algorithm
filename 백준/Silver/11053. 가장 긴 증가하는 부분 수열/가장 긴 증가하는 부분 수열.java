import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		int[] length = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int maxLen = 1;
		for (int i = 0; i < n; i++) {
			length[i] = 1;
			for (int j = 0; j < i; j++) {
				if (num[j] < num[i]) {
					length[i] = Math.max(length[i], length[j] + 1);
					maxLen = Math.max(maxLen, length[i]);
				}
			}
		}
		sb.append(maxLen);
		System.out.println(sb);
	}
}
