import java.util.*;
import java.io.*;

public class Main {
    
    private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	public static void main(String[] args) throws Exception {
		int n = read();
		int[][] time = new int[n][2];
		for (int i = 0; i < n; i++) {
			time[i][0] = read();
			time[i][1] = read();
		}
		Arrays.sort(time, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			if (!pq.isEmpty() && pq.peek() <= time[i][0]) {
				pq.poll();
			}
			pq.offer(time[i][1]);
		}
		System.out.println(pq.size());
	}
}
