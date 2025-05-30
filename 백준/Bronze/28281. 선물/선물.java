import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] price = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			min = Math.min(min, price[i] + price[i + 1]);
		}
		System.out.println(min * x);
	}
}