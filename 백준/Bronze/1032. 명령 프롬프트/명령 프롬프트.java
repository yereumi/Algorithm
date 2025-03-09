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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = read();
		String s = br.readLine();
		int size = s.length();
		char[] file = new char[size];
		for (int i = 0; i < size; i++) {
			file[i] = s.charAt(i);
		}
		for (int i = 0; i < n - 1; i++) {
			s = br.readLine();
			for (int j = 0; j < size; j++) {
				if (file[j] != s.charAt(j)) {
					file[j] = '?';
				}
			}
		}
		for (int i = 0; i < size; i++) {
			sb.append(file[i]);
		}
		System.out.println(sb);
	}
}