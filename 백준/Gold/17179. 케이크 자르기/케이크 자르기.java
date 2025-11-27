import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m, l;
	static int[] cutLine;
	
	static int binarySearch(int cutCnt) {
		int left = 1, right = l;
		int answer = 0;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (isPossible(cutCnt, mid)) {
				answer = mid;
				left = mid + 1;
			} else right = mid - 1;
		}
		
		return answer;
	}
	
	static boolean isPossible(int cutCnt, int len) {
		int cnt = 0;
		int prevCutLine = 0;
		
		for (int i = 0; i < m; i++) {
			if (cutLine[i] - prevCutLine >= len) {
				cnt++;
				prevCutLine = cutLine[i];
			}
		}
		
		if (l - prevCutLine < len) cnt--;
		
		return cnt >= cutCnt;
	}

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		cutLine = new int[m];
		for (int i = 0; i < m; i++) {
			cutLine[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < n; i++) {
			int q = Integer.parseInt(br.readLine());
			sb.append(binarySearch(q)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
