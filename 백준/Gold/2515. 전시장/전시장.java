import java.io.*;
import java.util.*;

public class Main {
	
	static int n, s;
	static int[][] pictures;
	static long[] dp;
	static long[] prefixMax;
	static int[] heights;
	
    static int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return ans;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		pictures = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			pictures[i][0] = Integer.parseInt(st.nextToken());
			pictures[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(pictures, (o1, o2) -> o1[0] - o2[0]);
		
		heights = new int[n];
		for (int i = 0; i < n; i++) heights[i] = pictures[i][0];

		dp = new long[n];
		prefixMax = new long[n];
		
		dp[0] = pictures[0][1];
        prefixMax[0] = dp[0];
        long answer = dp[0];

		for (int i = 1; i < n; i++) {
		    int h = pictures[i][0];
		    int c = pictures[i][1];

		    int idx = upperBound(heights, h - s);

            if (idx == -1) dp[i] = c;
            else dp[i] = c + prefixMax[idx];

            prefixMax[i] = Math.max(prefixMax[i - 1], dp[i]);
            answer = Math.max(answer, dp[i]);   
		}
		
        System.out.println(answer);
	}
}
