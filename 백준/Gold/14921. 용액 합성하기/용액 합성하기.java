import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] num = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Long.parseLong(st.nextToken());
		}
		
		long min = Long.MAX_VALUE;
		int left = 0, right = n - 1;
		
		while (left < right) {
			long sum = num[left] + num[right];
			if (Math.abs(sum) < Math.abs(min)) min = sum;
			
			if (sum < 0) left++;
			else right--;
		}
		
		System.out.println(min);
	}
}
