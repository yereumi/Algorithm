import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, Sr, Sc, Er, Ec;
	static int[][] board;
	static int[][][] dist;
	
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	static void dijkstra() {
	    dist = new int[N][M][3];
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            Arrays.fill(dist[i][j], Integer.MAX_VALUE);
	        }
	    }

	    dist[Sr][Sc][1] = 0;

	    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[3] - o2[3]);
	    pq.offer(new int[] { Sr, Sc, 1, 0 });

	    while (!pq.isEmpty()) {
	        int[] cur = pq.poll();
	        int r = cur[0], c = cur[1], idx = cur[2], cost = cur[3];
	        int nextIdx = (idx + 1) % 3;

	        if (cost > dist[r][c][idx]) continue;

	        if (idx == 0) {
	            for (int i = 0; i < 4; i++) {
	                int nr = r + dr[i], nc = c + dc[i];
	                if (!isValid(nr, nc)) continue;
	                if (board[nr][nc] == -1) continue;
	                if (cost + board[nr][nc] >= dist[nr][nc][nextIdx]) continue;

	                dist[nr][nc][nextIdx] = cost + board[nr][nc];
	                pq.offer(new int[] { nr, nc, nextIdx, dist[nr][nc][nextIdx] });
	            }
	        } else if (idx == 1) {
	            for (int i = 0; i < 2; i++) {
	                int nr = r + dr[i], nc = c + dc[i];
	                if (!isValid(nr, nc)) continue;
	                if (board[nr][nc] == -1) continue;
	                if (cost + board[nr][nc] >= dist[nr][nc][nextIdx]) continue;

	                dist[nr][nc][nextIdx] = cost + board[nr][nc];
	                pq.offer(new int[] { nr, nc, nextIdx, dist[nr][nc][nextIdx] });
	            }
	        } else {
	            for (int i = 2; i < 4; i++) {
	                int nr = r + dr[i], nc = c + dc[i];
	                if (!isValid(nr, nc)) continue;
	                if (board[nr][nc] == -1) continue;
	                if (cost + board[nr][nc] >= dist[nr][nc][nextIdx]) continue;

	                dist[nr][nc][nextIdx] = cost + board[nr][nc];
	                pq.offer(new int[] { nr, nc, nextIdx, dist[nr][nc][nextIdx] });
	            }
	        }
	    }
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Sr = Integer.parseInt(st.nextToken()) - 1;
		Sc = Integer.parseInt(st.nextToken()) - 1;
		Er = Integer.parseInt(st.nextToken()) - 1;
		Ec = Integer.parseInt(st.nextToken()) - 1;
		board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dijkstra();
		int answer = Math.min(dist[Er][Ec][0], Math.min(dist[Er][Ec][1], dist[Er][Ec][2]));
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
}
