import java.util.*;

class Solution {
    
    static int M, N;
    static int[][] pic;
    static boolean[][] visited;
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int[] dx = new int[] { 0, 0, -1, 1 };
    
    static boolean isValid(int y, int x) {
        return y >= 0 && y < M && x >= 0 && x < N;
    }
    

    static int bfs(int y, int x, int c) {
        Deque <int[]> dq = new ArrayDeque<>();
        
        int area = 1;
        dq.offer(new int[] { y, x });
        visited[y][x] = true;
        
        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if (isValid(ny, nx) && !visited[ny][nx] && pic[ny][nx] == c) {
                    dq.offer(new int[] { ny, nx });
                    visited[ny][nx] = true;
                    area++;
                }
            }
        }
        
        return area;
    }
    
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        M = m;
        N = n;
        visited = new boolean[m][n];
        pic = picture;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (pic[i][j] != 0 && !visited[i][j]) {
                    int area = bfs(i, j, pic[i][j]);
                    
                    if (area > 0) numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}