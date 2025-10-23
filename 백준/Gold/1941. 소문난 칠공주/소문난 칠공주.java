import java.io.*;
import java.util.*;

public class Main {
	
	static char[][] girls;
	static int answer;
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < 5 && c >= 0 && c < 5;
	}
	
	public static void backtracking(int depth, int idx, int[] arr) {
		if (depth == 7) {
			int y = 0, s = 0;
			for (int i = 0; i < 7; i++) { // 이다솜파가 우위인지 확인
				int r = arr[i] / 5;
				int c = arr[i] % 5;
				
				if (girls[r][c] == 'Y') y++;
				else s++;
			}
			
			if (s > y && bfs(arr)) answer++;
			return;
		}
		
		for (int i = idx + 1; i < 25; i++) {
			arr[depth] = i;
			backtracking(depth + 1, i, arr);
		}
	}
	
	public static boolean bfs(int[] arr) { // 조합이 연결돼있는지 확인
		boolean[][] selected = new boolean[5][5];
		boolean[][] visited = new boolean[5][5];
		
		for (int i = 0; i < 7; i++) {
			int r = arr[i] / 5;
			int c = arr[i] % 5;selected[r][c] = true;
		}
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { arr[0] / 5, arr[0] % 5 });
		visited[arr[0] / 5][arr[0] % 5] = true;
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				
				if (isValid(nr, nc) && selected[nr][nc] && !visited[nr][nc]) {
					dq.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (visited[i][j]) cnt++;
			}
		}
		
		if (cnt == 7) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		girls = new char[5][5];
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				girls[i][j] = str.charAt(j);
			}
		}
		
		answer = 0;
		
		for (int i = 0; i < 25; i++) {
			int[] arr = new int[7];
			arr[0] = i;
			backtracking(1, i, arr);
		}
		
		System.out.println(answer);
	}
}
