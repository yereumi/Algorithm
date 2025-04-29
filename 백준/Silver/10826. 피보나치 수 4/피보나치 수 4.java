import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigInteger[] fibo = new BigInteger[n + 2];
		fibo[0] = new BigInteger("0");
		fibo[1] = new BigInteger("1");
		for (int i = 2; i <= n; i++) {
			fibo[i] = fibo[i - 1].add(fibo[i - 2]);
		}
		System.out.println(fibo[n]);
	}
}