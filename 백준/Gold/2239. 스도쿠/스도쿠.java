import java.util.*;
import java.io.*;

public class Main {

	public static int[][] sudoku = new int[9][9];
	
	public static boolean isValid(int y, int x, int num) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][x] == num) return false;
		}
		for (int i = 0; i < 9; i++) {
			if (sudoku[y][i] == num) return false;
		}
		int xBlock = 3 * (x / 3);
		int yBlock = 3 * (y / 3);
		for (int i = yBlock; i < yBlock + 3; i++) {
			for (int j = xBlock; j < xBlock + 3; j++) {
				if (sudoku[i][j] == num) return false;
			}
		}
		return true;
	}
	
	public static void recursive(int depth) {
		if (depth > 81) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(sudoku[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		int x = depth % 9;
		int y = depth / 9;
		if (y >= 9) {
			x++;
			y = 0;
		}
		if (sudoku[y][x] != 0)  {
			recursive(depth + 1);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (isValid(y, x, i)) {
					sudoku[y][x] = i;
					recursive(depth + 1);
					sudoku[y][x] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
			}
		}
		recursive(0);
	}
}
