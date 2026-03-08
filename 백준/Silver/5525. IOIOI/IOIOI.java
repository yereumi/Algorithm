import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			if (S.charAt(i) == 'I') {
				int cnt = 0;
				int j = i + 1;
				while (j < M - 1 && S.charAt(j) == 'O' && S.charAt(j + 1) == 'I') {
					cnt++;
					i = j;
					j += 2;
				}
				if (cnt != 0) list.add(cnt);
			}
		}
		
		int answer = 0;
		for (int l : list) {
			int result = l + 1 - N;
			answer += result > 0 ? result : 0;
		}
		
		System.out.println(answer);
	}
}
