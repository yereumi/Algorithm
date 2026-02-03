import java.io.*;
import java.util.*;

public class Main {
	
	static int N, outSand;
	static int[][] board;
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	static void moveLeft(int r, int c, int sand) {
		int sand1 = (int) (sand * 0.01);
		if (isValid(r - 1, c + 1)) {
			board[r - 1][c + 1] += sand1;
		} else outSand += sand1;
		if (isValid(r + 1, c + 1)) {
			board[r + 1][c + 1] += sand1;
		} else outSand += sand1;
		
		int sand2 = (int) (sand * 0.02);
		if (isValid(r - 2, c)) {
			board[r - 2][c] += sand2;
		} else outSand += sand2;
		if (isValid(r + 2, c)) {
			board[r + 2][c] += sand2;
		} else outSand += sand2;
		
		int sand7 = (int) (sand * 0.07);
		if (isValid(r - 1, c)) {
			board[r - 1][c] += sand7;
		} else outSand += sand7;
		if (isValid(r + 1, c)) {
			board[r + 1][c] += sand7;
		} else outSand += sand7;
		
		int sand10 = (int) (sand * 0.1);
		if (isValid(r - 1, c - 1)) {
			board[r - 1][c - 1] += sand10;
		} else outSand += sand10;
		if (isValid(r + 1, c - 1)) {
			board[r + 1][c - 1] += sand10;
		} else outSand += sand10;
		
		int sand5 = (int) (sand * 0.05);
		if (isValid(r, c - 2)) {
			board[r][c - 2] += sand5;
		} else outSand += sand5;
		
		int total = sand1 * 2 + sand2 * 2 + sand7 * 2 + sand10 * 2 + sand5;
		board[r][c] = 0;
		if (isValid(r, c - 1)) {
			board[r][c - 1] += sand - total;
		} else outSand += sand - total;
	}
	
	static void moveRight(int r, int c, int sand) {
		int sand1 = (int) (sand * 0.01);
		if (isValid(r - 1, c - 1)) {
			board[r - 1][c - 1] += sand1;
		} else outSand += sand1;
		if (isValid(r + 1, c - 1)) {
			board[r + 1][c - 1] += sand1;
		} else outSand += sand1;
		
		int sand2 = (int) (sand * 0.02);
		if (isValid(r - 2, c)) {
			board[r - 2][c] += sand2;
		} else outSand += sand2;
		if (isValid(r + 2, c)) {
			board[r + 2][c] += sand2;
		} else outSand += sand2;
		
		int sand7 = (int) (sand * 0.07);
		if (isValid(r - 1, c)) {
			board[r - 1][c] += sand7;
		} else outSand += sand7;
		if (isValid(r + 1, c)) {
			board[r + 1][c] += sand7;
		} else outSand += sand7;
		
		int sand10 = (int) (sand * 0.1);
		if (isValid(r - 1, c + 1)) {
			board[r - 1][c + 1] += sand10;
		} else outSand += sand10;
		if (isValid(r + 1, c + 1)) {
			board[r + 1][c + 1] += sand10;
		} else outSand += sand10;
		
		int sand5 = (int) (sand * 0.05);
		if (isValid(r, c + 2)) {
			board[r][c + 2] += sand5;
		} else outSand += sand5;
		
		int total = sand1 * 2 + sand2 * 2 + sand7 * 2 + sand10 * 2 + sand5;
		board[r][c] = 0;
		if (isValid(r, c + 1)) {
			board[r][c + 1] += sand - total;
		} else outSand += sand - total;;
	}
	
	static void moveDown(int r, int c, int sand) {
		int sand1 = (int) (sand * 0.01);
		if (isValid(r - 1, c + 1)) {
			board[r - 1][c + 1] += sand1;
		} else outSand += sand1;
		if (isValid(r - 1, c - 1)) {
			board[r - 1][c - 1] += sand1;
		} else outSand += sand1;
		
		int sand2 = (int) (sand * 0.02);
		if (isValid(r, c - 2)) {
			board[r][c - 2] += sand2;
		} else outSand += sand2;
		if (isValid(r, c + 2)) {
			board[r][c + 2] += sand2;
		} else outSand += sand2;
		
		int sand7 = (int) (sand * 0.07);
		if (isValid(r, c - 1)) {
			board[r][c - 1] += sand7;
		} else outSand += sand7;
		if (isValid(r, c + 1)) {
			board[r][c + 1] += sand7;
		} else outSand += sand7;
		
		int sand10 = (int) (sand * 0.1);
		if (isValid(r + 1, c - 1)) {
			board[r + 1][c - 1] += sand10;
		} else outSand += sand10;
		if (isValid(r + 1, c + 1)) {
			board[r + 1][c + 1] += sand10;
		} else outSand += sand10;
		
		int sand5 = (int) (sand * 0.05);
		if (isValid(r + 2, c)) {
			board[r + 2][c] += sand5;
		} else outSand += sand5;
		
		int total = sand1 * 2 + sand2 * 2 + sand7 * 2 + sand10 * 2 + sand5;
		board[r][c] = 0;
		if (isValid(r + 1, c)) {
			board[r + 1][c] += sand - total;
		} else outSand += sand - total;
	}
	
	static void moveUp(int r, int c, int sand) {
		int sand1 = (int) (sand * 0.01);
		if (isValid(r + 1, c + 1)) {
			board[r + 1][c + 1] += sand1;
		} else outSand += sand1;
		if (isValid(r + 1, c - 1)) {
			board[r + 1][c - 1] += sand1;
		} else outSand += sand1;
		
		int sand2 = (int) (sand * 0.02);
		if (isValid(r, c - 2)) {
			board[r][c - 2] += sand2;
		} else outSand += sand2;
		if (isValid(r, c + 2)) {
			board[r][c + 2] += sand2;
		} else outSand += sand2;
		
		int sand7 = (int) (sand * 0.07);
		if (isValid(r, c - 1)) {
			board[r][c - 1] += sand7;
		} else outSand += sand7;
		if (isValid(r, c + 1)) {
			board[r][c + 1] += sand7;
		} else outSand += sand7;
		
		int sand10 = (int) (sand * 0.1);
		if (isValid(r - 1, c - 1)) {
			board[r - 1][c - 1] += sand10;
		} else outSand += sand10;
		if (isValid(r - 1, c + 1)) {
			board[r - 1][c + 1] += sand10;
		} else outSand += sand10;
		
		int sand5 = (int) (sand * 0.05);
		if (isValid(r - 2, c)) {
			board[r - 2][c] += sand5;
		} else outSand += sand5;
		
		int total = sand1 * 2 + sand2 * 2 + sand7 * 2 + sand10 * 2 + sand5;
		board[r][c] = 0;
		if (isValid(r - 1, c)) {
			board[r - 1][c] += sand - total;
		} else outSand += sand - total;
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	board = new int[N][N];
    	StringTokenizer st;
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int r = N / 2;
        int c = N / 2;
        int time = 1;
        outSand = 0;
        
        while (true) {
        	// 왼쪽 이동
        	for (int i = 0; i < time; i++) {
        		c--;
        		int sand = board[r][c];
        		moveLeft(r, c, sand);
        		if (r == 0 && c == 0) {
        			System.out.println(outSand);
        			return;
        		};
        	}
        	
        	// 아래쪽 이동
        	for (int i = 0; i < time; i++) {
        		r++;
        		int sand = board[r][c];
        		moveDown(r, c, sand);
        		if (r == 0 && c == 0) {
        			System.out.println(outSand);
        			return;
        		};
        	}
        	
        	time++;
        	
        	// 오른쪽 이동
        	for (int i = 0; i < time; i++) {
        		c++;
        		int sand = board[r][c];
        		moveRight(r, c, sand);
        		if (r == 0 && c == 0) {
        			System.out.println(outSand);
        			return;
        		};
        	}
        	
        	// 위쪽 이동
        	for (int i = 0; i < time; i++) {
        		r--;
        		int sand = board[r][c];
        		moveUp(r, c, sand);
        		if (r == 0 && c == 0) {
        			System.out.println(outSand);
        			return;
        		};
        	}
        	
        	time++;
        	
        	if (r == 0 && c == 0) {
    			System.out.println(outSand);
    			break;
    		};
        }
        
        br.close();
    }
}
