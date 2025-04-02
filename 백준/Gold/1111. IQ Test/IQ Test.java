import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		boolean m = n == 13;
		if (m) n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return m ? ~n + 1 : n;
	}
	
	public static void main(String[] args) throws Exception {
		int n = read();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = read();
		}
		if (n == 1) {
			System.out.println("A");
			System.exit(0);
		}
		else if (n < 3) {
			if (num[0] == num[1]) System.out.println(num[0]);
			else System.out.println("A");
			System.exit(0);
		}
		
		double a = 0, b = 0;
		boolean isSame = false;
		if (num[0] == num[1]) {
			for (int i = 1; i < n - 1; i++) {
				if (num[i] == num[i + 1]) continue;
				else {
					System.out.println("B");
					System.exit(0);
				}
			}
			System.out.println(num[0]);
			System.exit(0);
		} else {
			if (num[1] == num[2]) {
				for (int i = 1; i < n - 1; i++) {
					if (num[i] == num[i + 1]) continue;
					else {
						System.out.println("B");
						System.exit(0);
					}
				}
				System.out.println(num[1]);
				System.exit(0);
			} else {
				a = (num[2] - num[1]) / (num[1] - num[0]);
				b = num[1] - a * num[0];
				for (int i = 1; i < n - 1; i++) {
					if (a != (int) a) {
						System.out.println("B");
						System.exit(0);
					} else {
						if (a * num[i] + b != num[i + 1]) {
							System.out.println("B");
							System.exit(0);
						}
					}
				}
			}
		}
		System.out.println((int) (a * num[n - 1] + b));
	}
}