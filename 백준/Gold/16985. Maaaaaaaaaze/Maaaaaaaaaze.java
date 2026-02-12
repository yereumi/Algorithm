import java.io.*;
import java.util.*;

public class Main {
	
	static int answer = Integer.MAX_VALUE;
	static int[][][] origin = new int[5][5][5];
	static int[][][] selected = new int[5][5][5];
	static boolean[] used = new boolean[5];
	
	static int[][] delta = {{ 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 }, 
			{ -1, 0, 0 }, { 0, -1, 0 }, { 0, 0, -1 }};
	
	static boolean isValid(int x, int y, int z) {
		return x >= 0 && x < 5 && y >= 0 && y < 5 && z >= 0 && z < 5;
	}

	static void permute(int depth) {
		if (depth == 5) {
			selectMaze(selected, 0);
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (used[i]) continue;

			used[i] = true;

			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					selected[depth][r][c] = origin[i][r][c];
				}
			}

			permute(depth + 1);

			used[i] = false;
		}
	}
	
	static void selectMaze(int[][][] maze, int cnt) {
		if (cnt == 5) {
			answer = Math.min(answer, moveMaze(maze));
			return;
		}
				
		for (int i = 0; i < 4; i++) {
			selectMaze(maze, cnt + 1);
			maze[cnt] = rotateMaze(maze[cnt]);
		}
	}
	
	static int[][] rotateMaze(int[][] maze) {
		int[][] newMaze = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				newMaze[i][j] = maze[j][4 - i];
			}
		}
		return newMaze;
	}
	
	static int moveMaze(int[][][] maze) {
		if (maze[0][0][0] == 0 || maze[4][4][4] == 0) return Integer.MAX_VALUE;
				
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { 0, 0, 0, 0 });
		boolean[][][] visited = new boolean[5][5][5];
		visited[0][0][0] = true;
		
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			
			if (cur[3] >= answer) continue;
			if (cur[0] == 4 && cur[1] == 4 && cur[2] == 4) {
				return cur[3];
			}
			
			for (int i = 0; i < 6; i++) {
				int nx = cur[0] + delta[i][0];
				int ny = cur[1] + delta[i][1];
				int nz = cur[2] + delta[i][2];
				int nd = cur[3] + 1;
				
				if (isValid(nx, ny, nz) && !visited[nx][ny][nz] && maze[nx][ny][nz] == 1) {
					dq.offer(new int[] { nx, ny, nz, nd });
					visited[nx][ny][nz] = true;
				}
			}
		}
		
		return Integer.MAX_VALUE;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int i = 0; i < 5; i++) {
        	for (int j = 0; j < 5; j++) {
        		st = new StringTokenizer(br.readLine());
        		for (int k = 0; k < 5; k++) {
        			origin[i][j][k] = Integer.parseInt(st.nextToken());
        		}
        	}
        }
        
        permute(0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
         
        br.close();
    }
}
