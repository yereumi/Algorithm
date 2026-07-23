import java.io.*;
import java.util.*;

class Solution {
	
	static int N, K, answer;
	static int[][] map, tempMap;
	static boolean[][] visited;
	static List<int[]> highest;
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	static void backtracking(int r, int c, boolean shaved, int len) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (!isValid(nr, nc) || visited[nr][nc]) continue;
			
			if (tempMap[nr][nc] < tempMap[r][c]) {
				visited[nr][nc] = true;
				backtracking(nr, nc, shaved, len + 1);
				visited[nr][nc] = false;
			}
			
			if (!shaved && tempMap[nr][nc] >= tempMap[r][c]) {
				for (int j = tempMap[nr][nc] - tempMap[r][c] + 1; j <= K; j++) {
					visited[nr][nc] = true;
					tempMap[nr][nc] = map[nr][nc] - j;
					backtracking(nr, nc, true, len + 1);
					visited[nr][nc] = false;
					tempMap[nr][nc] = map[nr][nc];
				}
			}
		}
		
		answer = Math.max(answer, len);
	}
	
	public static void main(String args[]) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			tempMap = new int[N][N];
			visited = new boolean[N][N];
			highest = new ArrayList<>();
			int maxHeight = 0;
			answer = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					tempMap[i][j] = map[i][j];
					if (map[i][j] > maxHeight) {
						highest.clear();
						maxHeight = map[i][j];
						highest.add(new int[] { i, j });
					} else if (map[i][j] == maxHeight) {
						highest.add(new int[] { i, j });
					}
				}
			}
			
			for (int[] h : highest) {
				visited[h[0]][h[1]] = true;
				backtracking(h[0], h[1], false, 1);
				visited[h[0]][h[1]] = false;
			}
			
			sb.append("#" + t + " " + answer).append('\n');
		}
		
		System.out.println(sb.toString());
    }
}
