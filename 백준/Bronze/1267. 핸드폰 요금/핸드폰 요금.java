import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = 0, m = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			y += 10 * (num / 30 + 1);
			m += 15 * (num / 60 + 1);
		}
		if (y < m) System.out.println("Y " + y);
		else if (m < y) System.out.println("M " + m);
		else System.out.println("Y M " + y);
	}
}