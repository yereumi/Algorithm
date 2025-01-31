import java.util.*;
import java.io.*;

public class Main {

	private static void convertBaseToDecimal(int num, int base) {
		ArrayList<Character> list = new ArrayList<>();

		while (num > 0) {
			if (num % base < 10) {
				list.add((char) (num % base + '0'));
			} else {
				list.add((char) (num % base - 10 + 'A'));
			}
			num /= base;
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		convertBaseToDecimal(n, b);
	}
}
