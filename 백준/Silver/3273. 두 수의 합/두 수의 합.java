import java.util.*;
import java.io.*;

public class Main {	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int l = 0, r = n - 1, cnt = 0;
		while (l < r) {
			int sum = arr[l] + arr[r];
			if (sum == x) {
				cnt++;
				l++;
				r--;
			} else if (sum < x) {
				l++;
			} else if (sum > x) {
				r--;
			}
		}
		System.out.println(cnt);
	}
}
