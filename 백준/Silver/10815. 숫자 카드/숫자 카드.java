import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		long[] sCard = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			sCard[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sCard);
		int m = Integer.parseInt(br.readLine());
		long[] card = new long[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < m; i++) {
			int l = 0, r = sCard.length - 1;
			long num = card[i];
			int idx = Arrays.binarySearch(sCard, num);
			if (idx >= 0) sb.append("1 ");
			else sb.append("0 ");
		}
		System.out.println(sb);
	}
}
