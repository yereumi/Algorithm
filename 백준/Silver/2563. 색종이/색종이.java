import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine());
	        boolean[][] paper = new boolean[100][100];

	        while (n-- > 0) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            int x = Integer.parseInt(st.nextToken());
	            int y = Integer.parseInt(st.nextToken());

	            for (int i = x; i < x + 10; i++) {
	                for (int j = y; j < y + 10; j++) {
	                    paper[j][i] = true;
	                }
	            }
	        }

	        int area = 0;
	        for (int i = 0; i < 100; i++) {
	            for (int j = 0; j < 100; j++) {
	                if (paper[i][j]) area++;
	            }
	        }
	        System.out.println(area);
	    }
}
