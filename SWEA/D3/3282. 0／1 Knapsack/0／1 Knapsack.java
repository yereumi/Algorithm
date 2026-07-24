import java.io.*;
import java.util.*;

public class Solution {
	
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	int[][] items = new int[N][2];
        	for (int i = 0; i < N; i++) {
            	st = new StringTokenizer(br.readLine());
        		items[i][0] = Integer.parseInt(st.nextToken()); // 부피
        		items[i][1] = Integer.parseInt(st.nextToken()); // 가치
        	}
        	
        	Arrays.sort(items, (o1, o2) -> {
        		if (o1[0] != o2[0]) return o1[0] - o2[0];
        		return o1[1] - o2[1];
        	});
        	
        	int[] dp = new int[K + 1];
        	
        	for (int[] i : items) {
        		int v = i[0];
        		int c = i[1];
        		
        		for (int j = K; j >= v; j--) {
        			dp[j] = Math.max(dp[j], dp[j - v] + c);
        		}       		
        	}
        	
        	sb.append("#" + t + " " + dp[K]).append('\n');
        }
        
        System.out.println(sb.toString());
    }
}
