import java.io.*;
import java.util.*;

public class Main {
	
	static int N, L;
	static String[] words;
	
	public static boolean compare(String base) {
		for (String word : words) {
			int cnt = 0;
			for (int i = 0; i < L; i++) {
				if (word.charAt(i) != base.charAt(i)) cnt++;
			}
			
			if (cnt > 1) return false;
		}
		
		return true;
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	L = Integer.parseInt(st.nextToken());
    	words = new String[N];
    	for (int i = 0; i < N; i++) {
    		String word = br.readLine();
    		words[i] = word;
    	}
    	
    	String base = words[0];
    	
    	if (compare(base)) {
            System.out.println(base);
            return;
        }
    	
		char[] baseArr = base.toCharArray();

    	for (int i = 0; i < L; i++) {
    		char original = baseArr[i];
    		for (int j = 0; j < 26; j++) {
    			if ('A' + j == original) continue;
				baseArr[i] = (char) ('A' + j);
				base = new String(baseArr);
				
				if (compare(base)) {
					System.out.println(base);
					return;
				}
			}
    		baseArr[i] = original;
    	}
    	
    	System.out.println("CALL FRIEND");
    }
}
