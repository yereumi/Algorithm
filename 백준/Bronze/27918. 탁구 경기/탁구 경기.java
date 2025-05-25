import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int d = 0;
		int p = 0;
		
		for (int i = 0; i < n; i++) {
			String win = br.readLine();
			if (win.equals("D")) d++;
			else p++;
			if (d >= p + 2 || p >= d + 2) break;
		}
		
		System.out.println(d + ":" + p);
	}
}