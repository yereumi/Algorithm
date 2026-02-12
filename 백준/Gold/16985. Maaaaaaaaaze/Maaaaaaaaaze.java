import java.io.*;
import java.util.*;

public class Main {

	static int answer = Integer.MAX_VALUE;
	static int[][][] origin = new int[5][5][5];
	static int[][][][] rotated = new int[5][4][5][5];
	static int[][][] selected = new int[5][5][5];
	static boolean[] used = new boolean[5];

	static int[][] delta = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 },
			{ -1, 0, 0 }, { 0, -1, 0 }, { 0, 0, -1 } };

	static boolean isValid(int x, int y, int z) {
		return x >= 0 && x < 5 && y >= 0 && y < 5 && z >= 0 && z < 5;
	}

	static void makeRotation() {
		for (int i = 0; i < 5; i++) {
			rotated[i][0] = origin[i];

			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					rotated[i][1][4 - c][r] = origin[i][r][c];
					rotated[i][2][4 - r][4 - c] = origin[i][r][c];
					rotated[i][3][c][4 - r] = origin[i][r][c];
				}
			}
		}
	}

	static void build(int depth) {
		if (answer == 12) return;

		if (depth == 5) {
			answer = Math.min(answer, moveMaze());
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (used[i]) continue;
			used[i] = true;
			
			for (int rot = 0; rot < 4; rot++) {
				selected[depth] = rotated[i][rot];

				if (depth == 0 && selected[0][0][0] == 0) continue;

				build(depth + 1);
			}
			used[i] = false;
		}
	}

	static int moveMaze() {
		if (selected[0][0][0] == 0 || selected[4][4][4] == 0) return Integer.MAX_VALUE;

		boolean[][][] visited = new boolean[5][5][5];
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { 0, 0, 0, 0 });
		visited[0][0][0] = true;

		while (!dq.isEmpty()) {
			int[] cur = dq.poll();

			if (cur[3] >= answer) continue;
			if (cur[0] == 4 && cur[1] == 4 && cur[2] == 4) return cur[3];

			for (int i = 0; i < 6; i++) {
				int nx = cur[0] + delta[i][0];
				int ny = cur[1] + delta[i][1];
				int nz = cur[2] + delta[i][2];
				int nd = cur[3] + 1;

				if (isValid(nx, ny, nz) && !visited[nx][ny][nz] && selected[nx][ny][nz] == 1) {
					visited[nx][ny][nz] = true;
					dq.offer(new int[] { nx, ny, nz, nd });
				}
			}
		}

		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 5; k++) {
					origin[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		makeRotation();
		build(0);

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
}