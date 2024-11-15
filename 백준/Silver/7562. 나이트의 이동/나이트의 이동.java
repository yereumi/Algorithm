import java.util.*;
import java.io.*;

public class Main {
	static int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dx = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static boolean visited[][];
	static int l;

	static boolean isValid(int y, int x) {
		return (y >= 0 && y < l && x >= 0 && x < l);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T, answer = 0;
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			l = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int gy = Integer.parseInt(st.nextToken());
			int gx = Integer.parseInt(st.nextToken());
			visited = new boolean[l][l];

			Deque<int[]> dq = new ArrayDeque<>();
			dq.offer(new int[] { sy, sx, 0 });
			visited[sy][sx] = true;

			while (!dq.isEmpty()) {
				int[] knight = dq.poll();
				if (knight[0] == gy && knight[1] == gx) {
					System.out.println(knight[2]);
					break;
				}

				for (int i = 0; i < 8; i++) {
					int ny = knight[0] + dy[i];
					int nx = knight[1] + dx[i];

					if (isValid(ny, nx) && !visited[ny][nx]) {
						dq.offer(new int[] { ny, nx, knight[2] + 1 });
						visited[ny][nx] = true;
					}
				}
			}
		}
	}
}
