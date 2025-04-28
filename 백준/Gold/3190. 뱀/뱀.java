import java.util.*;
import java.io.*;

public class Main {
	static int n, k, l;
	static int[][] board;
	static Deque<String[]> direction;
	
	static int play() {
		int time = 1, nowR = 1, nowC = 1;
		char d = 'R';
		Deque<int[]> snake = new ArrayDeque<>();
		snake.offer(new int[] { 1, 1 });
		
		while (true) {
			if (d == 'L') nowC--;
			if (d == 'R') nowC++;
			if (d == 'U') nowR--;
			if (d == 'D') nowR++;
			if (board[nowR][nowC] == 2 || board[nowR][nowC] == 3) return time;
			
			if (board[nowR][nowC] == 0) {
				int[] last = snake.poll();
				board[last[0]][last[1]] = 0;
			} else if (board[nowR][nowC] == 1) {
				board[nowR][nowC] = 0;
			}
			snake.offer(new int[] { nowR, nowC });
			board[nowR][nowC] = 3;
			if (!direction.isEmpty() && Integer.parseInt(direction.peek()[0]) == time) {
				String[] dir = direction.poll();
				if (dir[1].equals("L")) {
					if (d == 'L') d = 'D';
					else if (d == 'R') d = 'U';
					else if (d == 'U') d = 'L';
					else if (d == 'D') d = 'R';
				}
				if (dir[1].equals("D")) {
					if (d == 'L') d = 'U';
					else if (d == 'R') d = 'D';
					else if (d == 'U') d = 'R';
					else if (d == 'D') d = 'L';
				}
			}
			time++;
		}	
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n + 2][n + 2]; // 0: 빈 칸, 1: 사과, 2: 벽, 3: 뱀
		k = Integer.parseInt(br.readLine());
		while (k-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[r][c] = 1;
		}
		l = Integer.parseInt(br.readLine());
		direction = new ArrayDeque<>();
		while (l-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String x = st.nextToken().toString();
			String c = st.nextToken().toString();
			direction.offer(new String[] { x, c });
		}
		board[1][1] = 3;
		for (int i = 0; i < n + 2; i++) {
			board[0][i] = board[i][0] = board[i][n + 1] = board[n + 1][i] = 2;
		}
		System.out.println(play());
	}
}