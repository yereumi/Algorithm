import java.util.*;
import java.io.*;

public class Main {

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		boolean m = n == 13;
		if (m)
			n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return m ? ~n + 1 : n;
	}

	public static void main(String[] args) throws Exception {
		int n = read();
		int k = read();
		int[] sensor = new int[n];
		for (int i = 0; i < n; i++) {
			sensor[i] = read();
		}
		Arrays.sort(sensor);
		PriorityQueue<Long> distance = new PriorityQueue<>((o1, o2) -> Long.compare(o2, o1));
		int totalDistance = 0;
		for (int i = 0; i < n - 1; i++) {
			long d = sensor[i + 1] - sensor[i];
			distance.offer(d);
			totalDistance += d;
		}
		for (int i = 0; i < k - 1; i++) {
			if (distance.isEmpty()) break;
			totalDistance -= distance.poll();
		}
		System.out.println(totalDistance);
	}
}
