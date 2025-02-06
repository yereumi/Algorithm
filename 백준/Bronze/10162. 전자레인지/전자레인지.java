import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n % 10 != 0) System.out.println(-1);
		else {
			int[] time = new int[3];
			time[0] = n / 300;
			n = n % 300;
			time[1] = n / 60;
			n = n % 60;
			time[2] = n / 10;
			System.out.println(time[0] + " " + time[1] + " " + time[2]);
		}
		br.close();
	}
}
