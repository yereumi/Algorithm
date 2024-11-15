import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] answer;
	static StringBuilder sb = new StringBuilder();
	
	public static void recursive(int depth) {
		if (depth >= m) {
			for (int i = 0; i < m; i++) {
				sb.append(answer[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			answer[depth] = i;
			recursive(depth + 1);
//			answer[depth] = 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		answer = new int[m];
		
		recursive(0);
		System.out.println(sb);
		// ㅠㅠ
	}
}
