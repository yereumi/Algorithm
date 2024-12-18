import java.util.*;
import java.io.*;

public class Main {
	
	public static int n, m;
	public static int[] answer;
	public static StringBuilder sb;
	
	public static void recursive(int depth, int num) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(answer[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = num; i <= n; i++) {
			answer[depth] = i;
			recursive(depth + 1, i + 1);
		}
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[m];
        recursive(0, 1);
        System.out.println(sb);
    }
}
