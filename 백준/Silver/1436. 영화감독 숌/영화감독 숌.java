import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int i = 1;
		while (true) {
			if (Integer.toString(i).contains("666")) {
				cnt++;
			}
			if (cnt == n) break;
			i++;
		}
		System.out.println(i);
	}
}
