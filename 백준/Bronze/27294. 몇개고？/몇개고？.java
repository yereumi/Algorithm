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
		int t = read();
		int s = read();
		
		if (s == 1 || t <= 11 || t > 16) System.out.println(280);
		else if (s == 0 && t >= 12 && t <= 16) System.out.println(320);
	}
}
