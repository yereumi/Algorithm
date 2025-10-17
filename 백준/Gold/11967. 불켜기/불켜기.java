import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] board;
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 1 && r <= n && c >= 1 && c <= n;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n + 1][n + 1];
		Map<String, List<int[]>> point = new HashMap<>();
		
		for (int i = 0; i < m; i++) {
			String[] p = br.readLine().split(" ");
		    int x = Integer.parseInt(p[0]);
		    int y = Integer.parseInt(p[1]);
		    int a = Integer.parseInt(p[2]);
		    int b = Integer.parseInt(p[3]);

		    String key = x + "," + y;
		    point.putIfAbsent(key, new ArrayList<>());
		    point.get(key).add(new int[]{a, b});
		}
		
		boolean[][] light = new boolean[n + 1][n + 1];
		light[1][1] = true;
		boolean[][] visited = new boolean[n + 1][n + 1];
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { 1, 1 });
		visited[1][1] = true;
		
		while (!dq.isEmpty()) {
		    int[] now = dq.poll();

		    String key = now[0] + "," + now[1];
		    if (point.containsKey(key)) {
		        for (int[] l : point.get(key)) {
		            if (!light[l[0]][l[1]]) {
		                light[l[0]][l[1]] = true;

		                for (int i = 0; i < 4; i++) {
		                    int nr = l[0] + dr[i];
		                    int nc = l[1] + dc[i];
		                    if (isValid(nr, nc) && visited[nr][nc]) {
		                        dq.offer(new int[] { nr, nc });
		                    }
		                }
		            }
		        }
		    }

		    for (int i = 0; i < 4; i++) {
		        int nr = now[0] + dr[i];
		        int nc = now[1] + dc[i];
		        if (isValid(nr, nc) && !visited[nr][nc] && light[nr][nc]) {
		            visited[nr][nc] = true;
		            dq.offer(new int[] { nr, nc });
		        }
		    }
		}
		
		int cnt = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (light[i][j]) cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
