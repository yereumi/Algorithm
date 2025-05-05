import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		if (m >= 3) System.out.println("After");
		else if (m == 2) {
			if (n == 18) System.out.println("Special");
			else if (n > 18) System.out.println("After");
			else System.out.println("Before");
		} else System.out.println("Before");
	}
}