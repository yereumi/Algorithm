import java.util.*;
import java.io.*;

public class Main {	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String status = st.nextToken();
			if (status.equals("enter")) set.add(name);
			else set.remove(name);
		}
		List<String> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());
		for (String name : list) sb.append(name).append("\n");
		System.out.println(sb);
	}
}
