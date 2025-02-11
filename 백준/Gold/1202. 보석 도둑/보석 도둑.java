import java.util.*;
import java.io.*;

public class Main {

	private static long read() throws Exception {
		long c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	public static void main(String[] args) throws Exception {
		int n = (int) read();
		int k = (int) read();
		long[][] gem = new long[n][2];
		long[] bag = new long[k];
		for (int i = 0; i < n; i++) {
			gem[i][0] = read();
			gem[i][1] = read();
		}
		for (int i = 0; i < k; i++) {
			bag[i] = read();
		}
		Arrays.sort(bag);
		Arrays.sort(gem, (o1, o2) -> {
			return (int) (o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
		});
		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long maxValue = 0;
        int gemIdx = 0;
        for (long b : bag) {
            while (gemIdx < n && gem[gemIdx][0] <= b) {
                pq.add(gem[gemIdx][1]);
                gemIdx++;
            }
            if (!pq.isEmpty()) {
                maxValue += pq.poll();
            }
        }
		System.out.println(maxValue);
	}
}
