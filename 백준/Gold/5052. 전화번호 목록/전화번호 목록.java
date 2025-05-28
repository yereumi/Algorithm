import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			List<String> numbers = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				numbers.add(br.readLine());
			}
			Collections.sort(numbers);
			boolean flag = false;
			
			for (int i = 0; i < n - 1; i++) {
				String cur = numbers.get(i);
				if (i == 0) {
					if (numbers.get(1).startsWith(cur)) flag = true;
				} else {
					if (numbers.get(i + 1).startsWith(cur) || cur.startsWith(numbers.get(i - 1))) flag = true;
				}
			}
			
			sb.append(flag ? "NO" : "YES").append("\n");
		}
        System.out.println(sb);
	}
}