import java.util.*;
import java.io.*;

public class Main {
	
	public static int calculation(long a, long b, int cnt) {
		if (a == b) return cnt;
		if (a > b) return -1;
		
		int result = calculation(a * 2, b, cnt + 1);
		if (result != -1) return result;
		result = calculation(a * 10 + 1, b, cnt + 1);
		if (result != -1) return result;
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println(calculation(a, b, 1));
	}
}
