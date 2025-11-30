import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n];
		long[] weight = new long[26];
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
			
			int len = words[i].length();
            long place = 1;
            
			for(int j = len - 1; j >= 0; j--){
                char ch = words[i].charAt(j);
                weight[ch - 'A'] += place;
                place *= 10;
            }
		}
		
		Arrays.sort(weight);
		int result = 0;
		int num = 9;
		for (int i = 25; i >= 0; i--) {
			if (weight[i] == 0) break;
            result += weight[i] * num;
			num--;
		}
		
		System.out.println(result);
	}
}
