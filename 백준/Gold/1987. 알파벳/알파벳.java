/**
 * 시간 2초: 2억번 안에 연산
 * 최대 메모리 256MB: int 기준 대략 256 * 1000 * 1000 / 4 = 64_000_000개 할당 가능
 * 1<=R,C<=20 -> O(N^3)까지 가능(시간은 신경쓰지 않아도 됨)
 */
import java.util.*;
import java.io.*;

public class Main {
	static int r, c, maxCnt;
	static char[][] board;
	static boolean[][] visited;
	static List<Character> list;
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int[] dx = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int y, int x) {
		return y >= 0 && y < r && x >= 0 && x < c;
	}
	
	static void dfs(int y, int x, int cnt) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i], nx = x + dx[i];
			if (isValid(ny, nx) && !visited[ny][nx] && !list.contains(board[ny][nx])) {
				visited[ny][nx] = true;
				list.add(board[ny][nx]);
				dfs(ny, nx, cnt + 1);
				visited[ny][nx] = false;
				list.remove(list.size() - 1);
				
			}
		}
		maxCnt = Math.max(maxCnt, cnt);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		visited = new boolean[r][c];
		visited[0][0] = true;
		list = new ArrayList<>();
		list.add(board[0][0]);
		maxCnt = 0;
		dfs(0, 0, 1);
		System.out.println(maxCnt);
	}
}