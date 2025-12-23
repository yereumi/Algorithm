import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[6];
		for (int i = 0; i < 6; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		// 6
		int answer = num[5];
		
		// 5 + 1
		answer += num[4];
		num[0] -= 11 * num[4];
		
		// 4 + 2 / 1
		answer += num[3];
		if (num[1] < 5 * num[3]) {
			num[0] -= 5 * 4 * num[3] - num[1] * 4;
			num[1] = 0;
		} else {
			num[1] -= 5 * num[3];
		}
		
		// 3 + 3
		answer += num[2] / 4;
		num[2] %= 4;
		if (num[2] != 0) answer++;
		
		// 1, 2를 3 빈자리에 넣기
		if (num[2] == 1) {
			if (num[1] < 5) {
				num[0] -= 27 - num[1] * 4;
				num[1] = 0;
			} else {
				num[1] -= 5;
				num[0] -= 7;
			}
		} else if (num[2] == 2) {
			if (num[1] < 3) {
				num[0] -= 18 - num[1] * 4;
				num[1] = 0;
			} else {
				num[1] -= 3;
				num[0] -= 6;
			}
		} else if (num[2] == 3) {
			if (num[1] < 1) {
				num[0] -= 9 - num[1] * 4;
				num[1] = 0;
			} else {
				num[1] -= 1;
				num[0] -= 5;
			}
		}
		
		if (num[1] < 0) num[1] = 0;
		if (num[0] < 0) num[0] = 0;

		// 2
		answer += num[1] / 9;
		num[1] %= 9;
		if (num[1] != 0) {
			answer++;
			num[0] -= 36 - num[1] * 4;
		}
		
		// 1
		while (num[0] > 0) {
			answer++;
			num[0] -= 36;
		}
		
		System.out.println(answer);
	}
}
