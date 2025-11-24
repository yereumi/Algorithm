import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static String[] arr;
	static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

	static void backtrack(String str, int cnt) {
        if (cnt == n) {
            answer = Math.min(answer, str.length());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            String merged = merge(str, arr[i]);
            backtrack(merged, cnt + 1);
            visited[i] = false;
        }
    }

    static String merge(String now, String next) {
        int maxOverlap = getOverlap(now, next);
        return now + next.substring(maxOverlap);
    }
    
    static int getOverlap(String now, String next) {
        int max = Math.min(now.length(), next.length());
        for (int k = max; k >= 1; k--) {
            if (now.endsWith(next.substring(0, k))) return k;
        }
        return 0;
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new String[n];
		visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
				
		for (int i = 0; i < n; i++) {
            visited[i] = true;
            backtrack(arr[i], 1);
            visited[i] = false;
        }
		
		System.out.println(answer);
	}
}
