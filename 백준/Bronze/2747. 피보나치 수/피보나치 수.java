import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int f1 = 0, f2 = 1;
		int answer = f1 + f2;
		while (num-- > 2) {
			f1 = f2;
			f2 = answer;
			answer = f1 + f2;
		}
		System.out.println(answer);
	}
}
