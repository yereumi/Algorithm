import java.util.*;
import java.io.*;

public class Main {
	
	static int n, k, visitedMask, max;
	static int[] wordMask;
	
	static void init() {
		String str = "antic";
		
		for (char c : str.toCharArray()) {
			visitedMask |= 1 << (c - 'a');
		}
	}
	
	static void backtracking(int a, int depth) {
		
		if (depth == k - 5) {
			int cnt = 0;
			
			for (int i : wordMask) {
				if ((i & visitedMask) == i) cnt++;
			}
			max = Math.max(max, cnt);
			return;
		}
		
		for (int i = a; i < 26; i++) {
			if ((visitedMask & (1 << i)) == 0) {
				visitedMask |= 1 << i;
				backtracking(i + 1, depth + 1);
				visitedMask &= ~(1 << i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		wordMask = new int[n];
		
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			int mask = 0;
			
			for (char c : word.toCharArray()) {
				mask |= 1 << (c - 'a'); 
			}
			wordMask[i] = mask;
		}
        
		init();
		max = 0;
		backtracking(0, 0);
		System.out.println(max);
		
	}
}