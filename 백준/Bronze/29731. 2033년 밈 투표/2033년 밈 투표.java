import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<String> strs = new ArrayList<>(Arrays.asList(
			    "Never gonna give you up",
			    "Never gonna let you down",
			    "Never gonna run around and desert you",
			    "Never gonna make you cry",
			    "Never gonna say goodbye",
			    "Never gonna tell a lie and hurt you",
			    "Never gonna stop"
			));
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			if (!strs.contains(str)) {
				System.out.println("Yes");
                System.exit(0);
			}
		}
		System.out.println("No");
	}
}