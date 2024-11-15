import java.util.*;
import java.io.*;

public class Main {
	static int n, answer = 0;
	static boolean[][] visited;
	static int[] dy = { -1, -1, -1 };
	static int[] dx = { -1, 0, 1 };

	public static boolean isValid(int y, int x) {
		return (y >= 0 && y < n && x >= 0 && x < n);
	}

	public static boolean find(int y, int x) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				int ny = y + i * dy[j];
				int nx = x + i * dx[j];
				if (isValid(ny, nx) && visited[ny][nx]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void recursive(int depth) {
		if (depth == n) {
			answer++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (find(depth, i)) {
				visited[depth][i] = true;
				recursive(depth + 1);
				visited[depth][i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n][n];
		
		recursive(0);
		System.out.println(answer);
		// ㅠㅠ
	}
}
