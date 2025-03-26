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
		int h = read();
		int w = read();
		int[] wlist = new int[w];
		for (int i = 0; i < w; i++) {
			wlist[i] = read();
		}
		int l = 0, r = w - 1, answer = 0;
		while (l < r) {
			if (wlist[l] < wlist[r]) {
				int idx = l + 1;
				while (wlist[l] > wlist[idx]) {
					answer += wlist[l] - wlist[idx++];
				}
				l = idx;
			} else {
				int idx = r - 1;
				while (wlist[r] > wlist[idx]) {
					answer += wlist[r] - wlist[idx--];
				}
				r = idx;
			}
		}
		System.out.println(answer);
	}
}