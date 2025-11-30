import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] rooms = new int[n][2];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			rooms[i][0] = Integer.parseInt(st.nextToken());
			rooms[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(rooms, (o1, o2) -> o1[0] - o2[0]);
		
		for (int i = 0; i < n; i++) {
			int[] now = rooms[i];
			int start = now[0];
			int end = now[1];
			
			if (!pq.isEmpty() && pq.peek() <= start) {
				pq.poll();
			}
			pq.offer(end);
		}
		
		System.out.println(pq.size());
	}
}
