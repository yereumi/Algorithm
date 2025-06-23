import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d1 = Integer.parseInt(st.nextToken());
		int d2 = Integer.parseInt(st.nextToken());
		int d3 = Integer.parseInt(st.nextToken());
		
		double a = 0, b = 0, c = 0;
		double sum = (d1 + d2 + d3) / 2.0;
		for (int i = 0; i < 3; i++) {
			if (sum - d1 <= 0) {
				System.out.println(-1);
				break;
			} else {
				c = sum - d1;
			}
			if (sum - d2 <= 0) {
				System.out.println(-1);
				break;
			} else {
				b = sum - d2;
			}
			if (sum - d3 <= 0) {
				System.out.println(-1);
				break;
			} else {
				a = sum - d3;
			}
		}
		
		if (a > 0 && b > 0 && c > 0) {
			System.out.println(1);
			System.out.println(a + " " + b + " " + c);
		}
	}
}