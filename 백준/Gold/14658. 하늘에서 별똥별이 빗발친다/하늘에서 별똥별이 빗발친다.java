import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, L, K;
	static int[][] stars;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        stars = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
        }

        int maxBounce = 0;

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int startX = stars[i][0];
                int startY = stars[j][1];

                int cnt = 0;
                for (int k = 0; k < K; k++) {
                    if (stars[k][0] >= startX && stars[k][0] <= startX + L &&
                        stars[k][1] >= startY && stars[k][1] <= startY + L) {
                        cnt++;
                    }
                }

                maxBounce = Math.max(maxBounce, cnt);
            }
        }

        System.out.println(K - maxBounce);
        
        br.close();
    }
}
