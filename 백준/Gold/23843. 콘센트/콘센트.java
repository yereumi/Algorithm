import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] time = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			time[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(time);
		
		PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1, o2));
		for (int i = 0; i < M; i++) {
			pq.offer(0L);
		}
		
		for (int i = N - 1; i >= 0; i--) {
			long t = pq.poll() + time[i];
			pq.offer(t);
		}
		
		long answer = 0;
		for (int i = 0; i < M; i++) {
			long t = pq.poll();
			if (t == 0) continue;
			answer = Math.max(answer, t);
		}
		
		System.out.println(answer);
	}
}
