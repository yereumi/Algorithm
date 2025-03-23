import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Map<String, List<String>> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String garb = st.nextToken();
				String type = st.nextToken();
				map.putIfAbsent(type, new ArrayList<>());
				map.get(type).add(garb);
			}
			int total = 1;
			for (String key : map.keySet()) {
				total *= (map.get(key).size() + 1);
			}
			sb.append(total - 1).append("\n");
		}
		System.out.println(sb);
	}
}