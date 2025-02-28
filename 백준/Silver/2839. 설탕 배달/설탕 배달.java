import java.util.*;
import java.io.*;

public class Main {
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48) 
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
	static int sugar(int n) {
		for (int i = n / 5; i >= 0; i--) {
			if ((n - 5 * i) % 3 == 0) return i + (n - 5 * i) / 3;
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		int n = read();
		System.out.println(sugar(n));
	}
}
