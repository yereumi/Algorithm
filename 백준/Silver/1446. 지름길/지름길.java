import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        Map<Integer, List<int[]>> shortcuts = new HashMap<>();
        int[] dp = new int[d + 1];
        Arrays.fill(dp, d);
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int length = Integer.parseInt(st.nextToken());
        	
        	if (end > d || length >= end - start) continue;
        	shortcuts.computeIfAbsent(start, k -> new ArrayList<>())
        	.add(new int[] { end, length });
        }
        
        for (int i = 0; i <= d; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1); // 일반 도로 전진(항상)
            }
            for (int[] sc : shortcuts.getOrDefault(i, Collections.emptyList())) {
                int e = sc[0], len = sc[1];
                dp[e] = Math.min(dp[e], dp[i] + len);   // 지름길 전이
            }
        }
        System.out.println(dp[d]);
            }
}