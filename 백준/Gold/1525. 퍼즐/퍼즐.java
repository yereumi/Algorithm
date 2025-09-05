import java.util.*;
import java.io.*;

public class Main {

	static int[][] board;
	static final String GOAL = "123456780";
	static String start = "";
	
	static int[] dx = new int[] { 0, 0, -1, 1 };
	static int[] dy = new int[] { -1, 1, 0, 0 };
	
	static boolean isValid(int y, int x) {
		return y >= 0 && y < 3 && x >= 0 && x < 3;
	}
	
	static int bfs(String start) {
		Deque<String> dq = new ArrayDeque<>();
		Map<String, Integer> dist = new HashMap<>();
		Set<String> visited = new HashSet<>();

		dq.offer(start);
		visited.add(start);
		dist.put(start, 0);

		while (!dq.isEmpty()) {
			String now = dq.poll();
			
			int d = dist.get(now);
		    if (now.equals(GOAL)) {
		        return d;
		    }
		    
			int idx = now.indexOf('0');
			int y = idx / 3;
			int x = idx % 3;
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				int nextIdx = ny * 3 + nx;
				
				if (isValid(ny, nx)) {
					char[] arr = now.toCharArray(); // 문자열을 char[]로 변환
					
					// 스왑
					char tmp = arr[idx];
					arr[idx] = arr[nextIdx];
					arr[nextIdx] = tmp;
					
					// 다시 문자열로
					String next = new String(arr);
					
					if (!visited.contains(next)) {
						visited.add(next);
						dist.put(next, d + 1);
			            dq.add(next);
					}
				}
			}
		}
		
		return -1;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        board = new int[3][3];
         
        for (int i = 0; i < 3; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < 3; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        		start += String.valueOf(board[i][j]);
        	}
        }
        
        System.out.println(bfs(start));
    }
}