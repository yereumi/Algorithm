import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String name = br.readLine();
			char c = name.charAt(0);
			if (map.containsKey(c)) {
				map.put(name.charAt(0), map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		List<Character> name = new ArrayList<>();
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= 5) name.add(entry.getKey());
		}
		Collections.sort(name);
		for (Character c : name) sb.append(c);
		if (!sb.toString().isEmpty()) System.out.println(sb);
		else System.out.println("PREDAJA");
	}
}