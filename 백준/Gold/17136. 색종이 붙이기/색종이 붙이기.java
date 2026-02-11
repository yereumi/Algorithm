import java.io.*;
import java.util.*;

public class Main {
	
	static int answer = Integer.MAX_VALUE;
	static int[] colorPapers;
	static int[][] board;
	static boolean[][] paper;
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < 10 && c >= 0 && c < 10;
	}
	
	static void backtracking(int idx, int cnt) {
		if (cnt >= answer) return;

	    if (idx == 100) {
	        answer = Math.min(answer, cnt);
	        return;
	    }
	    
		int r = idx / 10;
		int c = idx % 10;

		if (board[r][c] == 0 || paper[r][c]) {
	        backtracking(idx + 1, cnt);
	        return;
	    }
		
		for (int k = 5; k >= 1; k--) {

	        if (colorPapers[k] == 0) continue;

	        if (fillPaper(r, c, k)) {
	            colorPapers[k]--;

	            backtracking(idx + 1, cnt + 1);

	            colorPapers[k]++;
	            resetPaper(r, c, k);
	        }
	    }
	}
	
	static boolean fillPaper(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (!isValid(i, j) || paper[i][j] || board[i][j] == 0) {
					return false;
				}
			}
		}
		
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				paper[i][j] = true;
			}
		}
		
		return true;
	}
	
	static void resetPaper(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				paper[i][j] = false;
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        colorPapers = new int[6];
        for (int i = 1; i < 6; i++) {
        	colorPapers[i] = 5;
        }
        
        board = new int[10][10];
        for (int i = 0; i < 10; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < 10; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());	
        	}
        }
        
        paper = new boolean[10][10];
        backtracking(0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? - 1 : answer);
        
        br.close();
    }
}
