import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] meetings = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meetings, (o1, o2) -> {
			if (o1[1] != o2[1]) return o1[1] - o2[1];
			return o1[0] - o2[0];
		});
		
		int lastEndTime = 0;
		int cnt = 0;
		
		for (int[] m : meetings) {
			int s = m[0];
			int e = m[1];
			
			if (lastEndTime <= s) {
				cnt++;
				lastEndTime = e;
			}
		}
		
		System.out.println(cnt);
		
		br.close();
	}
}
