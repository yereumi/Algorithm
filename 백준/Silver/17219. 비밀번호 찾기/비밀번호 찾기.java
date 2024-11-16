import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		Map<String, String> pw = new HashMap<String, String>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			pw.put(st.nextToken(), st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			System.out.println(pw.get(line));
		}
	}
}
