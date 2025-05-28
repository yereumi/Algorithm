import java.util.*;
import java.io.*;

public class Main {
	
	static int d, p, standard, max;
	static List<Map<Integer, Integer>> dp;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		d = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		standard = 1;
		for  (int i = 0; i < d; i++) {
			standard *= 10;
		}
		dp = new ArrayList<>();
		for (int i = 0; i <= p; i++) {
		    dp.add(new HashMap<>());
		}
		max = -1;
		backtracking(0, 1);
		System.out.println(max);
	}
	
	static void backtracking(int depth, int num) {
		
		if (num >= standard) return;
		if (dp.get(depth).containsKey(num)) return;
		dp.get(depth).put(num, 1);
		if (depth == p) {
			max = Math.max(max, num);
			return;
		}
		
		for (int i = 9; i >= 2; i--) {
			num *= i;
			backtracking(depth + 1, num);
			num /= i;
		}
	}
}