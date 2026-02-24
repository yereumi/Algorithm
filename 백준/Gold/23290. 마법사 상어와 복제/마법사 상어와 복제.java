import java.io.*;
import java.util.*;

public class Main {
	
	static int M, S, sr, sc, max, maxNum;
	static int[][] board;
	static int[][] fish; // 물고기 냄새 저장
	static boolean[][] visited;
	static Deque<int[]> dq, next;
	
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };
	
	static int[] dsr = { -1, 0, 1, 0 };
	static int[] dsc = { 0, -1, 0, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < 4 && c >= 0 && c < 4;
	}
	
	static void moveFish() {
		board = new int[4][4];
	    next = new ArrayDeque<>();
	    int size = dq.size();

	    for (int i = 0; i < size; i++) {
	        int[] cur = dq.poll();
	        next.offer(cur);

	        int r = cur[0];
	        int c = cur[1];
	        int d = cur[2];

	        boolean moved = false;

	        for (int j = 0; j < 8; j++) {
	            int nd = (d - j + 8) % 8;
	            int nr = r + dr[nd];
	            int nc = c + dc[nd];

	            if (!isValid(nr, nc) || (nr == sr && nc == sc) || fish[nr][nc] > 0) continue;

	            dq.offer(new int[]{nr, nc, nd});
	            board[nr][nc]++;
	            moved = true;
	            break;
	        }

	        if (!moved) {
	            dq.offer(new int[]{r, c, d});
	            board[r][c]++;
	        }
	    }
	}
	
	static void moveShark() {
		max = 0;
		maxNum = 999;
		visited = new boolean[4][4];
		moveSharkBacktracking(0, sr, sc, 0, 0);
		String num = String.valueOf(maxNum);
		
		int nr = sr;
		int nc = sc;
		
		for (int i = 0; i < 3; i++) {
			int n = num.charAt(i) - '0' - 1;
			
			nr += dsr[n];
			nc += dsc[n];
			
			if (board[nr][nc] > 0) {
				board[nr][nc] = 0;
				fish[nr][nc] = 3;
			}
		}
		
		sr = nr;
		sc = nc;
	}
	
	static void moveSharkBacktracking(int idx, int r, int c, int fishCnt, int num) {
		if (idx == 3) {
			if (fishCnt > max || (fishCnt == max && num < maxNum)) {
			    max = fishCnt;
			    maxNum = num;
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
		    int nr = r + dsr[i];
		    int nc = c + dsc[i];

		    if (!isValid(nr, nc)) continue;

		    int nextNum = num * 10 + i + 1;
		    boolean first = !visited[nr][nc];
	        int added = 0;

	        if (first) {
	            visited[nr][nc] = true;
	            added = board[nr][nc];
	        }

	        moveSharkBacktracking(idx + 1, nr, nc, fishCnt + added, nextNum);

	        if (first) {
	            visited[nr][nc] = false;
	        }
		}
	}
	
	static void removeSmell() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (fish[i][j] > 0) fish[i][j]--;
			}
		}
	}
	
	static void copy() {
		Deque<int[]> newDq = new ArrayDeque<>();

		for (int[] cur : dq) {
			if (board[cur[0]][cur[1]] != 0) newDq.offer(new int[] { cur[0], cur[1], cur[2] }); 
		}
		
		for (int[] cur : next) {
			newDq.offer(new int[]{ cur[0], cur[1], cur[2] });
			board[cur[0]][cur[1]]++;
		}
		
		dq = newDq;
	}
	
	static void count() {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				cnt += board[i][j];
			}
		}
		System.out.println(cnt);
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        fish = new int[4][4];

        dq = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	
        	dq.offer(new int[] { x - 1, y - 1, d - 1 });
        }
        
        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        
        for (int i = 0; i < S; i++) {
        	moveFish();
        	moveShark();
        	removeSmell();
        	copy();
        }
        
        count();
    }
}
