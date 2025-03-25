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
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			int startH = read();
			int startM = read();
			int startS = read();
			int endH = read();
			int endM = read();
			int endS = read();
			
			int s = 0, m = 0, h = 0;
			if (endS < startS) {
				endM--;
				endS += 60;
			}
			if (endM < startM) {
				endH--;
				endM += 60;
			}
			s = endS - startS;
			m = endM - startM;
			h = endH - startH;
			sb.append(h).append(" ").append(m).append(" ").append(s).append("\n");
		}
		System.out.println(sb);
	}
}