import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a = Integer.parseInt(br.readLine());
		int answer = 0;
		int prev = a;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			answer += Math.min(Math.abs(prev - num), 360 - Math.abs(prev - num));
			prev = num;
		}
		System.out.println(answer);
	}
}