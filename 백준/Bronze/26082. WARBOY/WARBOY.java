import java.util.*;
import java.io.*;

public class Main {

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	public static void main(String[] args) throws Exception {
		int a = read();
		int b = read();
		int c = read();
		System.out.println(b/a*c*3);
	}
}