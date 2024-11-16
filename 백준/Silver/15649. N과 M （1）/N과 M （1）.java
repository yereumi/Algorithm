import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static int[] arr;
	static boolean[] isUse;
	static StringBuilder sb = new StringBuilder();

	public static void recursive(int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (depth == 0) {
				arr[depth] = i;
				isUse[i - 1] = true;
			} else {
				if (!isUse[i - 1]) {
					arr[depth] = i;
					isUse[i - 1] = true;
				} else {
					continue;
				}
			}
			recursive(depth + 1);
			isUse[i - 1] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m];
		isUse = new boolean[n];
		recursive(0);
		System.out.println(sb);
	}
}
