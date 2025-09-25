import java.io.*;
import java.util.*;

public class Main {
	
	static int MAX = 10_000;
	static long[] fib;
	
	static void fibonacci(int p, long q) {
		fib[1] = fib[2] = 1L % q;

		for (int i = 3; i <= p; i++) {
			fib[i] = (fib[i - 1] + fib[i - 2]) % q;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int idx = 1;
		fib = new long[MAX + 1];

		while (idx <= n) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			long q = Integer.parseInt(st.nextToken());
			
			fibonacci(p, q);
			long m = fib[p];

			sb.append("Case #" + idx++ + ": " + m).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
