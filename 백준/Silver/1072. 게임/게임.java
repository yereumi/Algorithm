import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());
		int z = (int) (100* y / x);
		long left = 1;
		long right = 1_000_000_000;
		long answer = Long.MAX_VALUE;
		
		while (left <= right) {
			long mid = (left + right) / 2;
			int nowZ = (int) (100 * (y + mid) / (x + mid));
			
			if (nowZ <= z) {
				left = mid + 1;
			} else {
				right = mid - 1;
				answer = Math.min(answer, mid);
			}
		}
		
		if (answer == Long.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}
}
