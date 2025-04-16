/**
 * 시간 2초: 2억번 안에 연산
 * 최대 메모리 256MB: int 기준 대략 256 * 1000 * 1000 / 4 = 64_000_000개 할당 가능
 * 1<=N, L<=1000 -> O(N^3)까지 가능
 */
import java.util.*;
import java.io.*;

public class Main {
	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	

	public static void main(String[] args) throws Exception {
		int n = read();
		int[] num = new int[6];
		long oneMin = Integer.MAX_VALUE, oneMax = 0, sum = 0;
		for (int i = 0; i < 6; i++) {
			num[i] = read();
			oneMin = Math.min(oneMin, num[i]);
			oneMax = Math.max(oneMax, num[i]);
			sum += num[i];
		}
		long threeMin = Math.min(num[0] + num[1] + num[2], 
				Math.min(num[0] + num[1] + num[3], 
				Math.min(num[0] + num[2] + num[4], 
				Math.min(num[0] + num[3] + num[4],
				Math.min(num[1] + num[3] + num[5],
				Math.min(num[1] + num[2] + num[5],
				Math.min(num[2] + num[4] + num[5], num[3] + num[4] + num[5])))))));
		long twoMin = Math.min(num[0] + num[1],
				Math.min(num[0] + num[2],
				Math.min(num[0] + num[3],
				Math.min(num[0] + num[4],
				Math.min(num[1] + num[2],
				Math.min(num[1] + num[3],
				Math.min(num[1] + num[5],
				Math.min(num[2] + num[4],
				Math.min(num[2] + num[5],
				Math.min(num[3] + num[4],
				Math.min(num[3] + num[5], num[4] + num[5])))))))))));
//		System.out.println(threeMin + " " + twoMin + " " + oneMin);
		long answer = threeMin * 4 + 
				twoMin * 4 + twoMin * 8 * (n - 2) + 
				oneMin * 4 * (n - 2) + oneMin * 5 * (n - 2) * (n - 2);
		if (n >= 2) System.out.println(answer);
		else System.out.println(sum - oneMax);
	}
}