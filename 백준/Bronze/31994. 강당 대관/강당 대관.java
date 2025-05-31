import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxCnt = 0;
		String maxSeminar = "";
		for (int i = 0; i < 7; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String seminar = st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());
			
			if (cnt > maxCnt) {
				maxCnt = cnt;
				maxSeminar = seminar;
			}
		}
		System.out.println(maxSeminar);
	}
}