import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		
		for (int n : num) {
			if (n < 0) left.add(n);
			else right.add(n);
		}
		
		Collections.sort(left, (o1, o2) -> Math.abs(o2) - Math.abs(o1));
		Collections.sort(right, (o1, o2) -> Math.abs(o2) - Math.abs(o1));
		
		int answer = 0;
		for (int i = 0; i < left.size(); i += M) {
		    answer += Math.abs(left.get(i)) * 2;
		}
		
		for (int i = 0; i < right.size(); i += M) {
		    answer += Math.abs(right.get(i)) * 2;
		}
		
		int max = 0;
		for (int n : num) {
		    max = Math.max(max, Math.abs(n));
		}
		
		System.out.println(answer - max);
	}
}
