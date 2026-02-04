import java.io.*;
import java.util.*;

public class Main {
	
	static int[] fib;
	
	static void fibonacci() {
		fib[0] = 1;
		fib[1] = 1;
		
		for (int i = 2; i <= 40; i++) {
			fib[i] = fib[i - 2] + fib[i - 1];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] vips = new int[M + 1];
		for (int i = 0; i < M; i++) {
			vips[i] = Integer.parseInt(br.readLine());
		}
		vips[M] = N + 1;
		
		fib = new int[41];
		fibonacci();
		
		long answer = 1;
		int prev = 0;
		for (int i = 0; i <= M; i++) {
			answer *= fib[vips[i] - prev - 1];
			prev = vips[i];
		}
		System.out.println(answer);
		
		br.close();
	}
}
