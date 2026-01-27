import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        int[][] lectures = new int[n][2];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(lectures, (a, b) -> a[1] - b[1]);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.offer(lectures[i][0]);
			
			if (pq.size() > lectures[i][1]) {
				pq.poll();
			}
		}
		
		int answer = 0;
		while (!pq.isEmpty()) {
			answer += pq.poll();
		}
		
		System.out.println(answer);
		br.close();
	}
}
