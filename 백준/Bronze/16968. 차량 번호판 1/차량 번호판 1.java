import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String car = br.readLine();
		char preC = ' ';
		int answer = 1;
		for (int i = 0; i < car.length(); i++) {
			char c = car.charAt(i);
			if (c == 'c') {
				if (c == preC) answer *= 25;
				else answer *= 26;
			}
			if (c == 'd') {
				if (c == preC) answer *= 9;
				else answer *= 10;
			}
			preC = c;
		}
		System.out.println(answer);
	}
}