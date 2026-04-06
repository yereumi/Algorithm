import java.io.*;
import java.math.BigInteger;

public class Main {
	
	public static int N;
	public static StringBuilder sb;
	
	public static void hanoi(int n, int from, int to, int via) {
		if (n == 1) {
			sb.append(from).append(" ").append(to).append("\n");
			return;
		}
		hanoi(n - 1, from, via, to);
		sb.append(from + " " + to).append("\n");
		hanoi(n - 1, via, to, from);
	}

	public static void main(String[] args) throws Exception {
        sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		System.out.println(BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE));
        
		if (N <= 20) {
            hanoi(N, 1, 3, 2);
            System.out.println(sb.toString());
        }
	}
}
