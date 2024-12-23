import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String f = st.nextToken();
			if (f.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				set.add(num);
			} else if (f.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				if (set.contains(num)) set.remove(num);
			} else if (f.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				if (set.contains(num)) sb.append(1 + "\n");
				else sb.append(0 + "\n");
			} else if (f.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if (set.contains(num)) set.remove(num);
				else set.add(num);
			} else if (f.equals("all")) {
				set = new HashSet<>();
				for (int j = 1; j <= 20; j++) {
					set.add(j);
				}
			} else if (f.equals("empty")) {
				set = new HashSet<>();
			}
		}
		System.out.println(sb);
	}
}
