import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		int[] height = new int[1_000_001];
		for (int i = 0; i < N; i++) {
			int h = num[i];
			if (height[h] == 0) {
				cnt++;
				height[h - 1]++;
			} else {
				height[h]--;
				height[h - 1]++;
			}
			
		}
		
		System.out.println(cnt);
	}
}
