import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	boolean[][] board = new boolean[n][n];
    	for (int i = 0; i < n; i++) {
    		String line = br.readLine();
    		for (int j = 0; j < n; j++) {
    			board[i][j] = line.charAt(j) == '.' ? true : false;
    		}
    	}
    	
    	int cnt = 0;

    	for (int i = 0; i < n; i++) {
    	    int length = 0;
    	    for (int j = 0; j < n; j++) {
    	        if (board[i][j]) {
    	            length++;
    	        } else {
    	            if (length >= 2) cnt++;
    	            length = 0;
    	        }
    	    }
    	    if (length >= 2) cnt++;
    	}
    	sb.append(cnt + " ");
    	
    	cnt = 0;
    	for (int j = 0; j < n; j++) {
    	    int length = 0;
    	    for (int i = 0; i < n; i++) {
    	        if (board[i][j]) {
    	            length++;
    	        } else {
    	            if (length >= 2) cnt++;
    	            length = 0;
    	        }
    	    }
    	    if (length >= 2) cnt++;
    	}
    	sb.append(cnt);
    	
    	System.out.println(sb.toString());
    }
}
