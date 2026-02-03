import java.io.*;
import java.util.*;

public class Main {

	static int N, outSand;
	static int[][] board;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };

	// {dr, dc, percent}
	static int[][][] sandPattern = {
			{ // 왼쪽
				{ -1, 1, 1 }, { 1, 1, 1 },
				{ -2, 0, 2 }, { 2, 0, 2 },
				{ -1, 0, 7 }, { 1, 0, 7 },
				{ -1, -1, 10 }, { 1, -1, 10 },
				{ 0, -2, 5 } },
			{ // 아래쪽
				{ -1, -1, 1 }, { -1, 1, 1 },
				{ 0, -2, 2 }, { 0, 2, 2 },
				{ 0, -1, 7 }, { 0, 1, 7 },
				{ 1, -1, 10 }, { 1, 1, 10 },
				{ 2, 0, 5 } },
			{ // 오른쪽
				{ -1, -1, 1 }, { 1, -1, 1 },
				{ -2, 0, 2 }, { 2, 0, 2 },
				{ -1, 0, 7 }, { 1, 0, 7 },
				{ -1, 1, 10 }, { 1, 1, 10 },
				{ 0, 2, 5 } },
			{ // 위쪽
				{ 1, -1, 1 }, { 1, 1, 1 },
				{ 0, -2, 2 }, { 0, 2, 2 },
				{ 0, -1, 7 }, { 0, 1, 7 },
				{ -1, -1, 10 }, { -1, 1, 10 },
				{ -2, 0, 5 }}};

	static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	static void move(int r, int c, int dir) {
		int sand = board[r][c];
		int total = 0;

		for (int[] p : sandPattern[dir]) {
			int nr = r + p[0];
			int nc = c + p[1];
			int amount = sand * p[2] / 100;
			total += amount;

			if (isValid(nr, nc))
				board[nr][nc] += amount;
			else
				outSand += amount;
		}

		int ar = r + dr[dir];
		int ac = c + dc[dir];
		int remain = sand - total;

		if (isValid(ar, ac))
			board[ar][ac] += remain;
		else
			outSand += remain;

		board[r][c] = 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int r = N / 2;
		int c = N / 2;
		int time = 1;
		int dir = 0;
		outSand = 0;

		while (true) {
			for (int t = 0; t < 2; t++) {
				for (int i = 0; i < time; i++) {
					r += dr[dir];
					c += dc[dir];
					move(r, c, dir);
					if (r == 0 && c == 0) {
						System.out.println(outSand);
						return;
					}
				}
				dir = (dir + 1) % 4;
			}
			time++;

			if (r == 0 && c == 0) {
				System.out.println(outSand);
				break;
			}
		}

		br.close();
	}
}
