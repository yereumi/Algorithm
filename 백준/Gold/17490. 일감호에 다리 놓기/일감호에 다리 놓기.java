import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static long K;
	static int[] S;
	static int[] parent;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        
        S = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
        	S[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean[] broken = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if (a == N && b == 1) broken[a] = true;
        	else if (a == 1 && b == N) broken[b] = true;
        	else if (a < b) broken[a] = true;
        	else broken[b] = true;
        }
        
        if (M <= 1) {
        	System.out.println("YES");
        	return;
        }
        
        long sum = 0;
        int curMin = S[1];
        int firstMin = -1;
        int lastMin = -1;
        boolean hasBroken = false;

        for (int i = 1; i < N; i++) {
            curMin = Math.min(curMin, S[i]);

            if (broken[i]) {
                hasBroken = true;
                sum += curMin;

                if (firstMin == -1) firstMin = curMin;
                lastMin = curMin;

                curMin = S[i + 1];
            }
        }

        curMin = Math.min(curMin, S[N]);
        sum += curMin;
        lastMin = curMin;

        if (!hasBroken) {
            sum = curMin;
        } else if (!broken[N]) {
            sum = sum - firstMin - lastMin + Math.min(firstMin, lastMin);
        }

        System.out.println(sum <= K ? "YES" : "NO");
    }
}
