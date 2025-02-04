import java.util.*;
import java.io.*;

public class Main {	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		long[] house = new long[n];
		for (int i = 0; i < n; i++) {
			house[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(house);
		long[] distance = new long[n - 1];
		for (int i = 0; i < n - 1; i++) {
			distance[i] = house[i + 1] - house[i];
		}
		Arrays.sort(distance);
		long l = 0, r = 1_000_000_000, max = 0L; 
		while (l <= r) {
			long d = (l + r) / 2; // 공유기 간격
			boolean flag = false;
			int idx = 0;
			for (int i = 0; i < c - 1; i++) {
				int router = Arrays.binarySearch(house, house[idx] + d);
				if (router < 0) router = Math.abs(router) - 1;
				if (router >= n) {
					flag = true;
					r = d - 1;
					break;
				}
				idx = router;
			}
			if (!flag) {
				max = d;
				l = d + 1;
			}
		}
		System.out.println(max);
	}
}
