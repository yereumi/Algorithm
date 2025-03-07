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
		int plus = read();
		int minus = read();
		if (minus > plus || (plus + minus) % 2 != 0) {
            System.out.println(-1);
            return;
        }
        int num1 = (plus + minus) / 2;
        int num2 = (plus - minus) / 2;
        if (num1 < 0 || num2 < 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(num1 + " " + num2);
	}
}