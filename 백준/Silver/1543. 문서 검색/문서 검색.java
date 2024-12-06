import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String doc = br.readLine();
		String word = br.readLine();
		sb.append(doc);
		int cnt = 0;
		
		while (sb.toString().contains(word)) {
			int idx = sb.indexOf(word);
			sb.delete(0, idx + word.length());
			cnt++;
		}
        
		System.out.println(cnt);
	}
}
