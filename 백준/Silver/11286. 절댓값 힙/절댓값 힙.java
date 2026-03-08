import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if (Math.abs(o1) != Math.abs(o2)) return Math.abs(o1) - Math.abs(o2);
			return o1 - o2;
		});
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) pq.offer(num);
			else {
				if (pq.size() == 0) sb.append(0);
				else sb.append(pq.poll());
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
