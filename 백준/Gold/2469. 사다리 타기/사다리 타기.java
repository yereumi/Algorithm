import java.io.*;
import java.util.*;

public class Main {
	
	static int k, n;
	static String result;
	static char[][] board;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		result = br.readLine();
		board = new char[n][k - 1];
		int hiddenRow = 0;
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < k - 1; j++) {
				board[i][j] = tmp.charAt(j);
				if (board[i][j] == '?') hiddenRow = i;
			}
		}
		
		char[] up = new char[k];
		for (int i = 0; i < k; i++) {
		    up[i] = (char) ('A' + i);
		}
		
		for (int i = 0; i < hiddenRow; i++) {
		    for (int j = 0; j < k - 1; j++) {
		        if (board[i][j] == '-') {
		            char tmp = up[j];
		            up[j] = up[j + 1];
		            up[j + 1] = tmp;
		            j++;
		        }
		    }
		}
		
		char[] down = result.toCharArray();
		for (int i = n - 1; i > hiddenRow; i--) {
		    for (int j = 0; j < k - 1; j++) {
		        if (board[i][j] == '-') {
		            char tmp = down[j];
		            down[j] = down[j + 1];
		            down[j + 1] = tmp;
		            j++;
		        }
		    }
		}
		
		int i = 0;
		while (i < k - 1) {
			if (up[i] == down[i]) {
			    sb.append('*');
			    i++;
			} else if (up[i] == down[i + 1] && up[i + 1] == down[i]) {
			    sb.append('-');
			    if (i < k - 2) sb.append('*');

			    char tmp = up[i];
			    up[i] = up[i + 1];
			    up[i + 1] = tmp;

			    i += 2;
			} else {
			    System.out.println("x".repeat(k - 1));
			    return;
			}
		}
		
		System.out.println(sb.toString());
	}
}
