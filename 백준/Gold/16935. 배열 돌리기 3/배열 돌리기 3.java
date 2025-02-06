import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static int[][] arr, arrTmp;

	public static void calculate(int c) {
		if (c == 1) {
			for (int i = 0; i < arr[0].length; i++) {
				for (int j = 0; j < arr.length / 2; j++) {
					int tmp = arr[j][i];
					arr[j][i] = arr[arr.length - j - 1][i];
					arr[arr.length - j - 1][i] = tmp;
				}
			}
		} else if (c == 2) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length / 2; j++) {
					int tmp = arr[i][j];
					arr[i][j] = arr[i][arr[0].length - j - 1];
					arr[i][arr[0].length - j - 1] = tmp;
				}
			}
		} else if (c == 3) {
			arrTmp = new int[arr[0].length][arr.length];
			for (int i = 0; i < arr[0].length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arrTmp[i][j] = arr[arr.length - 1 - j][i];
				}
			}
			arr = new int[arrTmp.length][arrTmp[0].length];
			arr = arrTmp;
		} else if (c == 4) {
			arrTmp = new int[arr[0].length][arr.length];
			for (int i = 0; i < arr[0].length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arrTmp[i][j] = arr[j][arr[0].length - 1 - i];
				}
			}
			arr = new int[arrTmp.length][arrTmp[0].length];
			arr = arrTmp;
		} else if (c == 5) {
			int y = 0, x = 0, hn = arr.length / 2, hm = arr[0].length / 2;
			arrTmp = new int[arr.length][arr[0].length];
			for (int i = hn; i < arr.length; i++) {
				for (int j = 0; j < hm; j++) {
					if (x >= arr[0].length)
						x = 0;
					arrTmp[y][x++] = arr[i][j];
				}
				for (int j = 0; j < hm; j++) {
					if (x >= arr[0].length)
						x = 0;
					arrTmp[y][x++] = arr[i - hn][j];
				}
				y++;
			}
			for (int i = hn; i < arr.length; i++) {
				for (int j = hm; j < arr[0].length; j++) {
					if (x >= arr[0].length)
						x = 0;
					arrTmp[y][x++] = arr[i][j];
				}
				for (int j = hm; j < arr[0].length; j++) {
					if (x >= arr[0].length)
						x = 0;
					arrTmp[y][x++] = arr[i - hn][j];
				}
				y++;
			}
			arr = arrTmp;
		} else if (c == 6) {
			int y = 0, x = 0, hn = arr.length / 2, hm = arr[0].length / 2;
			arrTmp = new int[arr.length][arr[0].length];

			for (int i = 0; i < hn; i++) {
				for (int j = hm; j < arr[0].length; j++) {
					if (x >= arr[0].length)
						x = 0;
					arrTmp[y][x++] = arr[i][j];
				}
				for (int j = hm; j < arr[0].length; j++) {
					if (x >= arr[0].length)
						x = 0;
					arrTmp[y][x++] = arr[hn + i][j];
				}
				y++;
			}
			for (int i = 0; i < hn; i++) {
				for (int j = 0; j < hm; j++) {
					if (x >= arr[0].length)
						x = 0;
					arrTmp[y][x++] = arr[i][j];
				}
				for (int j = 0; j < hm; j++) {
					if (x >= arr[0].length)
						x = 0;
					arrTmp[y][x++] = arr[hn + i][j];
				}
				y++;
			}
			arr = arrTmp;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		arr = new int[n][m]; // n*m 배열 선언
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] cal = new int[r]; // 연산 번호를 담는 배열 선언
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < r; i++) {
			calculate(cal[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
