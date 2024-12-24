import java.util.*;
import java.io.*;

public class Main {

	public static int m, n, h;

	public static int[][][] tomato;
	public static int[] dz = { 0, 0, 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0, 0, 0 };
	public static int[] dx = { 0, 0, 1, -1, 0, 0 };

	public static boolean isValid(int z, int y, int x) {
		if (z >= 0 && z < h && y >= 0 && y < n && x >= 0 && x < m && tomato[z][y][x] != -1)
			return true;
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		tomato = new int[h][n][m];
		Deque<int[]> addedTomato = new ArrayDeque<>();
		Deque<int[]> tomatoList = new ArrayDeque<>();
		int cnt = 0;
		int cntZero = 0;
		boolean flag = false;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					if (tomato[i][j][k] == 1) {
						addedTomato.offer(new int[] { i, j, k });
					}
					if (tomato[i][j][k] == 0) {
						cntZero++;
					}
				}
			}
		}
		if (cntZero == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		while (!addedTomato.isEmpty()) {
			tomatoList = new ArrayDeque<>(addedTomato);
			addedTomato.clear();
			flag = false;
			while (!tomatoList.isEmpty()) {
				int[] newTomato = tomatoList.poll();
				int z = newTomato[0];
				int y = newTomato[1];
				int x = newTomato[2];
				
				for (int i = 0; i < 6; i++) {
					if (tomato[z][y][x] == 1 && isValid(z + dz[i], y + dy[i], x + dx[i])) {
						if (tomato[z + dz[i]][y + dy[i]][x + dx[i]] == 0) {
							tomato[z + dz[i]][y + dy[i]][x + dx[i]] = 1;
							addedTomato.offer(new int[] {z + dz[i], y + dy[i], x + dx[i] });
							flag = true;
						};
					}
				}
			}
			if (flag) cnt++;
		}
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (tomato[i][j][k] == 0) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}

		System.out.println(cnt);
	}
}
