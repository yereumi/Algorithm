/**
 * 시간 1초: 1억번 안에 연산
 * 최대 메모리 128MB: int 기준 대략 128 * 1000 * 1000 / 4 = 32_000_000개 할당 가능
 */
import java.util.*;
import java.io.*;

public class Main {
	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int[][] square = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				square[i][j] = read();
			}
		}
		int sum = -1;
		// 가로
		for (int i = 0; i < 3 && sum == -1; i++) {
			if (square[i][0] != 0 && square[i][1] != 0 && square[i][2] != 0)
				sum = square[i][0] + square[i][1] + square[i][2];
		}
		// 세로
		for (int i = 0; i < 3 && sum == -1; i++) {
			if (square[0][i] != 0 && square[1][i] != 0 && square[2][i] != 0)
				sum = square[0][i] + square[1][i] + square[2][i];
		}
		// 대각선
		if (sum == -1 && square[0][0] != 0 && square[1][1] != 0 && square[2][2] != 0)
			sum = square[0][0] + square[1][1] + square[2][2];
		if (sum == -1 && square[0][2] != 0 && square[1][1] != 0 && square[2][0] != 0)
			sum = square[0][2] + square[1][1] + square[2][0];
		if (sum == -1 && square[0][0] == 0 && square[1][1] == 0 && square[2][2] == 0)
			sum = (square[0][1] + square[0][2] + square[1][0] + square[1][2] + square[2][0] + square[2][1]) / 2;
		if (sum == -1 && square[0][2] == 0 && square[1][1] == 0 && square[2][0] == 0)
			sum = (square[0][0] + square[0][1] + square[1][0] + square[1][2] + square[2][1] + square[2][2]) / 2;
		
		for (int i = 0; i < 3; i++) {
			int now = 0;
			int idxI = -1, idxJ = -1;
			boolean flag = false;
			for (int j = 0; j < 3; j++) {
				if (square[i][j] == 0) {
					if (idxI != -1 && idxJ != -1) {
						flag = true;
						break;
					}
					idxI = i;
					idxJ = j;
					continue;
				}
				now += square[i][j];
			}
			if (!flag && sum != now) {
				square[idxI][idxJ] = sum - now;
			}
		}
		for (int i = 0; i < 3; i++) {
			int now = 0;
			int idxI = -1, idxJ = -1;
			boolean flag = false;
			for (int j = 0; j < 3; j++) {
				if (square[j][i] == 0) {
					if (idxI != -1 && idxJ != -1) {
						flag = true;
						break;
					}
					idxI = i;
					idxJ = j;
					continue;
				}
				now += square[j][i];
			}
			if (!flag && sum != now) {
				square[idxJ][idxI] = sum - now;
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(square[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}