
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
		int l = read();
		int[] water = new int[n];
		for (int i = 0; i < n; i++) {
			water[i] = read();
		}
		Arrays.sort(water);
		int answer = 0, len = 0;
		for (int i = 0; i < n - 1; i++) {
			int distance = water[i + 1] - water[i];
			if (distance >= l) {
				answer++;
				if (i == n - 2) answer++;
				len = 0;
			} else if (distance + len >= l) {
				answer++;
				if (i == n - 2) answer++;
				len = 0;
			} else {
				len += distance;
			}
		}
		if (len != 0) answer++;
		if (l == 1) answer = n;
		if (n == 1) answer = 1;
		System.out.println(answer);
	}
}