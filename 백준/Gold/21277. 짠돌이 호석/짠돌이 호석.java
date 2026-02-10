import java.io.*;
import java.util.*;

public class Main {
	
	static int N1, M1, N2, M2;
	static boolean[][] puzzle1, puzzle2;

	static boolean[][] rotate(int r, int c, boolean[][] puzzle) {
		int newR = c, newC = r;
		boolean[][] newPuzzle = new boolean[newR][newC];
		
		for (int i = 0; i < newR; i++) {
			for (int j = 0; j < newC; j++) {
				newPuzzle[i][j] = puzzle[r - 1 - j][i];
			}
		}
		
		return newPuzzle;
	}
	
	static boolean isValid(int dx, int dy, boolean[][] p1, boolean[][] p2) {
	    int r1 = p1.length, c1 = p1[0].length;
	    int r2 = p2.length, c2 = p2[0].length;

	    for (int i = 0; i < r1; i++) {
	        for (int j = 0; j < c1; j++) {
	            if (!p1[i][j]) continue;

	            int ni = i - dx;
	            int nj = j - dy;

	            if (0 <= ni && ni < r2 && 0 <= nj && nj < c2) {
	                if (p2[ni][nj]) return false;
	            }
	        }
	    }
	    return true;
	}
	
	static int area(int dx, int dy, boolean[][] p1, boolean[][] p2) {
	    int r1 = p1.length, c1 = p1[0].length;
	    int r2 = p2.length, c2 = p2[0].length;

	    int minR = Math.min(0, dx);
	    int minC = Math.min(0, dy);
	    int maxR = Math.max(r1, dx + r2);
	    int maxC = Math.max(c1, dy + c2);

	    return (maxR - minR) * (maxC - minC);
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N1 = Integer.parseInt(st.nextToken());
        M1 = Integer.parseInt(st.nextToken());
        puzzle1 = new boolean[N1][M1];
        for (int i = 0; i < N1; i++) {
        	String str = br.readLine();
        	for (int j = 0; j < M1; j++) {
        		if (str.charAt(j) == '1') puzzle1[i][j] = true;
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        N2 = Integer.parseInt(st.nextToken());
        M2 = Integer.parseInt(st.nextToken());
        puzzle2 = new boolean[N2][M2];
        for (int i = 0; i < N2; i++) {
        	String str = br.readLine();
        	for (int j = 0; j < M2; j++) {
        		if (str.charAt(j) == '1') puzzle2[i][j] = true;
        	}
        }
        
        int answer = Integer.MAX_VALUE;
        
        // 퍼즐 하나만 시계방향으로 90도씩 회전
        for (int i = 0; i < 4; i++) {
        	puzzle1 = rotate(puzzle1.length, puzzle1[0].length, puzzle1);
        	
        	for (int j = -puzzle2.length; j < puzzle1.length; j++) {
        		for (int k = -puzzle2[0].length; k < puzzle2[0].length; k++) {
        			if (isValid(j, k, puzzle1, puzzle2)) {
        				answer = Math.min(answer, area(j, k, puzzle1, puzzle2));
        			}
        		}
        	}
        }
        
        System.out.println(answer);
        
        br.close();
    }
}
