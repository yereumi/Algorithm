import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			if (x % 2 == 0) {
				x = (x / 2) ^ 6;
			} else {
				x = (x * 2) ^ 6;
			}
		}
		
		System.out.println(x);
	}
}