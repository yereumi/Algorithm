import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static int[] lecture;
	
	static boolean isPossible(int size) {
		int videoLen = 0, cnt = 0;
		for (int i = 0; i < n; i++) {			
			if (size < videoLen) return false;
			if (videoLen + lecture[i] > size) {
				cnt++;
				videoLen = lecture[i];
			} else {
				videoLen += lecture[i];
			}
		}
		
		cnt++;
		
		return cnt <= m;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int left = 1, right = 0;
		
		lecture = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			lecture[i] = Integer.parseInt(st.nextToken());
			right += lecture[i];
		}
		
		int answer = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (isPossible(mid)) {
				right = mid - 1;
				answer = mid;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(answer);
	}
}
