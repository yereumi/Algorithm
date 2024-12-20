import java.util.*;
import java.io.*;

public class Main {
	
	public static int n, m;
	public static int[] arr, answer;
	public static Set<String> set;
	public static StringBuilder sb;
	
	public static void recursive(int depth, int start) {
		if (depth == m) {
	        sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				sb.append(answer[i] + " ");
			}
			sb.append("\n");
			if (!set.contains(sb.toString())) set.add(sb.toString());
			return;
		}
		for (int i = start; i < n; i++) {
			answer[depth] = arr[i];
			recursive(depth + 1, i);	
		}
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answer = new int[m];
        set = new LinkedHashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        recursive(0, 0);
        sb = new StringBuilder();
        for (String str : set) {
        	sb.append(str);
        }
        System.out.println(sb);
        
    }
}
