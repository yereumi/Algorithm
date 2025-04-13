import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += Integer.parseInt(br.readLine());
		}
		System.out.println(total - sum);
	}
}