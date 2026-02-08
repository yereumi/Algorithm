import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int[] belt;
	static boolean[] robot;
	
	static void rotate() {
		// 벨트 회전
	    int last = belt[2 * N - 1];
	    for (int i = 2 * N - 1; i > 0; i--) {
	        belt[i] = belt[i - 1];
	    }
	    belt[0] = last;

	    // 로봇 회전
	    for (int i = N - 1; i > 0; i--) {
	        robot[i] = robot[i - 1];
	    }
	    robot[0] = false;
	    robot[N - 1] = false;
	}
	
	static void moveRobot() {
	    for (int i = N - 2; i >= 0; i--) {
	        if (!robot[i]) continue;
	        if (robot[i + 1]) continue;
	        if (belt[i + 1] == 0) continue;

	        robot[i] = false;
	        robot[i + 1] = true;
	        belt[i + 1]--;
	    }
	    robot[N - 1] = false;
	}

	static void addRobot() {
	    if (!robot[0] && belt[0] > 0) {
	        robot[0] = true;
	        belt[0]--;
	    }
	}
	
	static boolean isValid() {
		int cnt = 0;
		for (int i = 0; i < N * 2; i++) {
			if (belt[i] == 0) cnt++;
		}
		
		return cnt < K;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[N * 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
        	belt[i] = Integer.parseInt(st.nextToken());
        }
        
        robot = new boolean[N];
        int time = 0;
        
        while (true) {
        	if (!isValid()) break;
        	rotate();
            moveRobot();
            addRobot();
        	time++;
        }
        
        System.out.println(time);
        
        br.close();
    }
}
