import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static List<Long> list = new ArrayList<>();
	
	static void backtracking(int depth, int start, int[] num) {
		for (int i = start; i <= 9; i++) {
			num[depth] = i;
			save(num, depth);
			backtracking(depth + 1, i + 1, num);
		}
	}
	
	static void save(int[] num, int depth) {
		StringBuilder sb = new StringBuilder();
	    for (int i = depth; i >= 0; i--) {
	        sb.append(num[i]);
	    }
	    long value = Long.parseLong(sb.toString());
	    list.add(value);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		backtracking(0, 0, new int[10]);
		Collections.sort(list);

		System.out.println(n >= list.size() ? -1 : list.get(n));
	}
}