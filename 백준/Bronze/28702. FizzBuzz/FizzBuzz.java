import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = new String[3];
		for (int i = 0; i < 3; i++) {
			strs[i] = br.readLine();
		}
		int result = 0;
		for (int i = 2; i >= 0; i--) {
			try {
				int num = Integer.parseInt(strs[i]);
				result = 3 - i + num;
			} catch (Exception e) {
				continue;
			}
		}
		
		if (result % 5 == 0 && result % 3 == 0) {
			System.out.println("FizzBuzz");
		} else if (result % 3 == 0) {
			System.out.println("Fizz");
		} else if (result % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(result);
		}
	}
}
