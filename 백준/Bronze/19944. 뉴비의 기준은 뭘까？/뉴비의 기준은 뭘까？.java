import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if (m == 1 || m == 2) System.out.println("NEWBIE!");
		else if (m <= n) System.out.println("OLDBIE!");
		else System.out.println("TLE!");
	}
}