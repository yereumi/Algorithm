import java.util.*;
import java.util.Map.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			map.putIfAbsent(str, 0);
		}
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (map.containsKey(str)) map.replace(str, map.get(str) + 1);
		}
		int cnt = 0;
		for (Entry<String, Integer> maps : map.entrySet()) {
			cnt += maps.getValue();
		}
		
		System.out.println(cnt);
	}
}
