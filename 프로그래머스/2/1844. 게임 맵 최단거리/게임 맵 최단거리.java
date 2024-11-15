import java.util.*;

class Solution {
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int n, m;

	public static boolean isValid(int y, int x) {
		return (y >= 0 && y < n && x >= 0 && x < m); // 경계선 확인
	}

	public static int solution(int[][] maps) {

		n = maps.length;
		m = maps[0].length;
		int answer = -1;
		boolean[][] visited = new boolean[n][m];
		Deque<int[]> dq = new ArrayDeque<>(); // {y, x, depth}
		dq.offer(new int[] { 0, 0, 1 }); // 로봇의 초기 위치
		visited[0][0] = true;
		while (!dq.isEmpty()) { // 모든 움직임을 탐색할 때까지
			int[] robot = dq.poll(); // 움직일 로봇 꺼내기
			if (robot[0] == n - 1 && robot[1] == m - 1) {
				answer = robot[2];
				break;
			}
			for (int i = 0; i < 4; i++) {
				int ny = robot[0] + dy[i];
				int nx = robot[1] + dx[i];
				if (isValid(ny, nx) && !visited[ny][nx] && maps[ny][nx] == 1) { // 경계선, 방문, 벽 확인
					dq.offer(new int[] { ny, nx, robot[2] + 1 });
					visited[ny][nx] = true;
				}
			}
		}

		return answer;
	}
}