import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = 0, idx = 0;
		if (n + 8 > 209) {
			if (max < 209) {
				max = 209;
				idx = 1;
			}
		} else {
			if (max < n + 8) {
				max = n + 8;
				idx = 1;
			}
		}
		if (n + 4 > 219) {
			if (max < 219) {
				max = 219;
				idx = 2;
			}
		} else {
			if (max < n + 4) {
				max = n + 4;
				idx = 2;
			}
		}
		if (n + 2 > 229) {
			if (max < 229) {
				max = 229;
				idx = 3;
			}
		} else {
			if (max < n + 2) {
				max = n + 2;
				idx = 3;
			}
		}
		if (n + 1 > 239) {
			if (max < 239) {
				max = 239;
				idx = 4;
			}
		} else {
			if (max < n + 1) {
				max = n + 1;
				idx = 4;
			}
		}
		System.out.println(idx);
	}
}