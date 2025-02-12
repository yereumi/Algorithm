import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		TreeSet<String> ts = new TreeSet<>((o1, o2) -> o1.length() != o2.length() ? o1.length() - o2.length() : o1.compareTo(o2));
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			String len = Integer.toString(word.length());
			ts.add(word);
		}
		List<String> list = new ArrayList<>(ts);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}
