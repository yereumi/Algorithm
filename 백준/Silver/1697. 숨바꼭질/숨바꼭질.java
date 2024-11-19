import java.util.*;
import java.io.*;

public class Main {

	static int n, k;
	static int[] dx = new int[] { -1, 1, 2 };

	public static boolean isValid(int x) {
		return (x >= 0 && x <= 100000);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int answer = 0;
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[] visited = new boolean[1000000];
		dq.offer(new int[] { n, 0 });
		visited[n] = true;;

		while (!dq.isEmpty()) {
			int[] sb = dq.poll();
			if (sb[0] == k) {
				answer = sb[1];
				break;
			}
			for (int i = 0; i < 3; i++) {
				int nx;
				if (i == 2) {
					nx = sb[0] * dx[i];
				} else {
					nx = sb[0] + dx[i];
				}
				if (isValid(nx) && !visited[nx]) { // 시간초과 contains 때문...? 방문처리 우야
					dq.offer(new int[] { nx, sb[1] + 1 });
					visited[nx] = true;
				}
			}
		}
		System.out.println(answer);
	}
}
