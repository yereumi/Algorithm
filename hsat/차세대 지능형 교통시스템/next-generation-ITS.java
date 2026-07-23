import java.io.*;
import java.util.*;

public class Main {

    static int N, T;
    static int[][] crossroads;
    static boolean[] visited;

    // 위, 아래, 왼, 오
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static int[][] blinkers = { // (어디에서 왔는지) 방향, (어디로 갈지) 방향
            { 2, 0, 1, 3 }, { 1, 0, 2, 3 }, { 3, 0, 1, 2 }, { 0, 1, 2, 3 },
            { 2, 0, 3 }, { 1, 0, 2 }, { 3, 1, 2 }, { 0, 1, 3 },
            { 2, 1, 3 }, { 1, 0, 3 }, { 3, 0, 2 }, { 0, 1, 2 }
        };
    
    static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    
    static void backtracking(int depth, int idx, int direction, int time) {
        if (time == T) return;

        int r = idx / N, c = idx % N;
        int[] curRoad = crossroads[idx]; // 현재 교차로
        int curTime = time % 4; // 현재 시간
        int curBlinker = curRoad[curTime]; // 현재 교차로의 신호집합

        if (blinkers[curBlinker][0] != direction) return; // 신호가 맞지 않으면 return
        
        // 신호집합 순회
        for (int i = 1; i < blinkers[curBlinker].length; i++) {
            int d = blinkers[curBlinker][i];
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!isValid(nr, nc)) continue;

            visited[nr * N + nc] = true;
            int dir = 0; // 다음 백트래킹에 쓸 방향(어디에서 왔는지)
            if (dr[d] == -1) dir = 1;
            else if (dc[d] == -1) dir = 3;
            else if (dc[d] == 1) dir = 2;
            
            backtracking(depth + 1, nr * N + nc, dir, time + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        crossroads = new int[N * N][4];
        visited = new boolean[N * N];

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                crossroads[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        visited[0] = true;
        backtracking(0, 0, 1, 0);
        
        int answer = 0;
        for (int i = 0; i < N * N; i++) {
            if (visited[i]) answer++;
        }

        System.out.println(answer);
    }
}
