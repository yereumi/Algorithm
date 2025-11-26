import java.util.*;
import java.io.*;

public class Main {

	static int n, cnt;
	static boolean[] beforeSwitch, afterSwitch;
	static String before, after;

	static boolean light() {
		for (int i = 1; i < n; i++) {
			if (beforeSwitch[i - 1] == afterSwitch[i - 1]) continue;

			change(i - 1);
			change(i);
			if (i != n - 1) change(i + 1);
			cnt++;
		}

		return isSame();
	}

	static void change(int i) {
		if (beforeSwitch[i]) beforeSwitch[i] = false;
		else beforeSwitch[i] = true;
	}
	
	static boolean isSame() {
	    for (int i = 0; i < n; i++) {
	        if (beforeSwitch[i] != afterSwitch[i]) return false;
	    }
	    return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		before = br.readLine();
		beforeSwitch = new boolean[n];
		for (int i = 0; i < n; i++) {
			beforeSwitch[i] = before.charAt(i) == '0' ? true : false;
		}

		after = br.readLine();
		afterSwitch = new boolean[n];
		for (int i = 0; i < n; i++) {
			afterSwitch[i] = after.charAt(i) == '0' ? true : false;
		}

		int minCnt = Integer.MAX_VALUE;
		if (before.equals(after)) System.out.println(0);
		else {
			// 첫 번째 스위치 누를 때
			cnt = 1;
			change(0);
			change(1);
			if (light()) minCnt = Math.min(minCnt, cnt);
			
			beforeSwitch = new boolean[n];
			for (int i = 0; i < n; i++) {
				beforeSwitch[i] = before.charAt(i) == '0' ? true : false;
			}
			
			// 첫 번째 스위치 안 누를 때
			cnt = 0;
			if (light()) minCnt = Math.min(minCnt, cnt);
			if (minCnt == Integer.MAX_VALUE) minCnt = -1;
			
			System.out.println(minCnt);
		}
	}
}
