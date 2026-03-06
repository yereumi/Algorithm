import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] buildings = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Integer> dq = new ArrayDeque<>();
		int[] cnt = new int[N];
		int[] near = new int[N];
		Arrays.fill(near, -1);

		for (int i = 0; i < N; i++) {
			int h = buildings[i];

			while (!dq.isEmpty() && buildings[dq.peek()] <= h) {
				dq.pop();
			}

			cnt[i] += dq.size();

			if (!dq.isEmpty()) {
				near[i] = dq.peek();
			}

			dq.push(i);
		}

		dq.clear();

		for (int i = N - 1; i >= 0; i--) {
			int h = buildings[i];

			while (!dq.isEmpty() && buildings[dq.peek()] <= h) {
                dq.pop();
            }

			cnt[i] += dq.size();

			if (!dq.isEmpty()) {
                int idx = dq.peek();

                if (near[i] == -1 || Math.abs(i - idx) < Math.abs(i - near[i])) {
                    near[i] = idx;
                }
            }

			dq.push(i);
		}

		for (int i = 0; i < N; i++) {
			if (cnt[i] == 0) {
                sb.append(0).append("\n");
            } else {
                sb.append(cnt[i]).append(" ")
                  .append(near[i] + 1).append("\n");
            }
		}

		System.out.println(sb.toString());
	}
}
