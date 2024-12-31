import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new TreeSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			map.put(num, 0);
			set.add(num);
		}
		int idx = 0;
		for (int num : set) {
			map.replace(num, idx);
			idx++;
		}
		for (int i = 0; i < n; i++) {
			sb.append(map.get(arr[i]) + " ");
		}
		System.out.println(sb);
	}
}
