import java.util.*;
import java.io.*;

public class Main {
    
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48) 
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
    
	public static void main(String[] args) throws Exception {
		int n1 = read();
		int k1 = read();
		int n2 = read();
		int k2 = read();
		
		System.out.println(n1 * k1 + n2 * k2);
	}
}
