import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
	public static void main(String[] args) throws Exception {
		int[] num = new int[3];
		for (int i = 0; i < 3; i++) {
			num[i] = read();
		}
		Arrays.sort(num);
		if (num[0] + num[1] > num[2]) {
			System.out.println(num[0] + num[1] + num[2]);
		} else {
			System.out.println((num[0] + num[1]) * 2 - 1);
		}
		
	}
}