import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		int excludeNum = (int) Math.round(n * 0.3 / 2);
		int sum = 0;
		for (int i = excludeNum; i < n - excludeNum; i++) {
			sum += num[i];
		}
		System.out.println(Math.round((double) sum / (n - excludeNum * 2)));
	}
}
