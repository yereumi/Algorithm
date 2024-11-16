import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			String num = br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			Deque<Integer> dq = new ArrayDeque<>();
			for (int j = 0; j < 8; j++) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			int cycle = 1;
			while (dq.peekLast() != 0) {
				if (cycle == 6) {
					cycle = 1;
				}
				int next = dq.poll() - cycle;
				if (next <= 0) {
					next = 0;
				}
				dq.offer(next);
				cycle++;
			}
			System.out.print("#" + i + " ");
			for (int j = 0; j < 8; j++) {
				System.out.print(dq.poll() + " ");
			}
		}
	}
}