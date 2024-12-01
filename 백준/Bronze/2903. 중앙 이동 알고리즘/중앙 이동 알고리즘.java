import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dot = 2;
		for (int i = 1; i <= n; i++) {
			dot += dot - 1;
		}
		System.out.println((int)Math.pow(dot, 2));
	}
}
