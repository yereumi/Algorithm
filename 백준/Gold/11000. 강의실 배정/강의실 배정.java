import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] classes = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			classes[i][0] = Integer.parseInt(st.nextToken());
			classes[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(classes, (o1, o2) -> {
			if (o1[0] != o2[0]) return o1[0] - o2[0];
			return o1[1] - o2[1];
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
		
		for (int[] c : classes) {
			int s = c[0];
			int e = c[1];
			
			if (!pq.isEmpty() && pq.peek() <= s) {
                pq.poll();
            }

            pq.offer(e);
		}
		
		System.out.println(pq.size());
		
		br.close();
	}
}
