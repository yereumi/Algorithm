import java.io.*;
import java.util.*;

public class Main {
	
	static int n, k, m, max;
	static Set<String> visited;
	
	static void bfs(String num, int count) {
		if (num.startsWith("0")) return;

		if (count == k) {
			max = Math.max(max, Integer.parseInt(num));
			return;
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < m; j++) {
				char[] charNum = new char[m];
				for (int p = 0; p < m; p++) {
					charNum[p] = num.charAt(p);
				}
								
				char tmp = charNum[i];
				charNum[i] = charNum[j];
				charNum[j] = tmp;
				
				String nextNum = String.copyValueOf(charNum);
				if (visited.contains(nextNum + count)) continue;
				visited.add(nextNum + count);
				bfs(nextNum, count + 1);
			}
		}
		
		return;
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	m = String.valueOf(n).length();
    	max = 0;
    	
    	visited = new HashSet<>();
    	
    	if (m <= 1) {
    		System.out.println(-1);
    		return;
    	}
    	
    	bfs(String.valueOf(n), 0);
    	
    	System.out.println(max == 0 ? -1 : max);
    }
}