import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++) {
			list.remove(st.nextToken());
		}
		System.out.println(list.get(0));
	}
}