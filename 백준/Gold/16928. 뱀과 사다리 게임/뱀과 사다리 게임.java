import java.util.*;
import java.io.*;

public class Main {
	static int minCnt;
	static Map<Integer, Integer> ladder, snake;
	static int[] dice = new int[] { 6, 5, 4, 3, 2, 1 };
	
	static int play() {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { 1, 0 });
		boolean[] visited = new boolean[107];
		int minCnt = Integer.MAX_VALUE;
        
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			int num = now[0];
			int cnt = now[1];
			if (num == 100) {
				minCnt = Math.min(minCnt, cnt);
				continue;
			}
			if (num > 100) continue;
			for (int i = 0; i < 6; i++) {
				int nextNum = num + dice[i];
				
				if (!visited[nextNum]) {
					if (snake.containsKey(nextNum)) {
						visited[nextNum] = true;
						dq.offer(new int[] { snake.get(nextNum), cnt + 1 });
					} else if (ladder.containsKey(nextNum)) {
						visited[ladder.get(nextNum)] = true;
						dq.offer(new int[] { ladder.get(nextNum), cnt + 1 });
					} else {
						visited[nextNum] = true;
						dq.offer(new int[] { nextNum, cnt + 1 });
					}
				}
			}
		}
		return minCnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ladder = new HashMap<>();
		snake = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		System.out.println(play());
		
	}
}