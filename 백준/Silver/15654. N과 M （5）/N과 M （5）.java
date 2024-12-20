import java.util.*;
import java.io.*;

public class Main {
	
	public static int n, m;
	public static int[] arr, answer;
	public static StringBuilder sb;
	
	public static void recursive(int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(answer[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			boolean flag = false;
			for (int j = 0; j < depth; j++) {
				if (answer[j] == arr[i]) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				answer[depth] = arr[i];
				recursive(depth + 1);
			}
		}
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answer = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        recursive(0);
        System.out.println(sb);
        
    }
}
