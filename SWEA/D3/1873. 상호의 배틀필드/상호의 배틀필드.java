import java.io.*;
import java.util.*;

public class Solution {
	
	static int h, w;
	
	static boolean isValid(int y, int x) {
		return y >= 0 && y < h && x >= 0 && x < w;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		int tt = 1;
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			int startY = 0, startX = 0, direction = 0; // direction: 방향을 나타내는 변수(0: 위, 1: 아래, 2: 왼쪽, 3: 오른쪽)
			char[][] game = new char[h][w];
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					game[i][j] = str.charAt(j);
					if (game[i][j] == '<' || game[i][j] == '>' || game[i][j] == '^' || game[i][j] == 'v') {
						startY = i;
						startX = j;
						if (game[i][j] == '^') direction = 0;
						if (game[i][j] == 'v') direction = 1;
						if (game[i][j] == '<') direction = 2;
						if (game[i][j] == '>') direction = 3;
					}
				}
			}
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for (int i = 0; i < n; i++) {
				char now = str.charAt(i);
				int ny = startY, nx = startX;
				
				if (now == 'U') {
					ny--;
					direction = 0;
					game[startY][startX] = '^';

					if (isValid(ny, nx) && game[ny][nx] == '.') {
						game[startY][startX] = '.';
						startY = ny;
						startX = nx;
						game[startY][startX] = '^';
					}
				} else if (now == 'D') {
					ny++;
					direction = 1;
					game[startY][startX] = 'v';

					if (isValid(ny, nx) && game[ny][nx] == '.') {
						game[startY][startX] = '.';
						startY = ny;
						startX = nx;
						game[startY][startX] = 'v';
					}
				} else if (now == 'L') {
					nx--;
					direction = 2;
					game[startY][startX] = '<';

					if (isValid(ny, nx) && game[ny][nx] == '.') {
						game[startY][startX] = '.';
						startY = ny;
						startX = nx;
						game[startY][startX] = '<';
					}
				} else if (now == 'R') {
					nx++;
					direction = 3;
					game[startY][startX] = '>';

					if (isValid(ny, nx) && game[ny][nx] == '.') {
						game[startY][startX] = '.';
						startY = ny;
						startX = nx;
						game[startY][startX] = '>';
					}
				} else if (now == 'S') {
					if (direction == 0) {
						while (isValid(ny, nx)) {
							if (game[ny][nx] == '#') break;
							if (game[ny][nx] == '*') {
								game[ny][nx] = '.';
								break;
							}
							ny--;

						}
					} else if (direction == 1) {
						while (isValid(ny, nx)) {
							if (game[ny][nx] == '#') break;
							if (game[ny][nx] == '*') {
								game[ny][nx] = '.';
								break;
							}
							ny++;
						}
					} else if (direction == 2) {
						while (isValid(ny, nx)) {
							if (game[ny][nx] == '#') break;
							if (game[ny][nx] == '*') {
								game[ny][nx] = '.';
								break;
							}
							nx--;
						}
					} else if (direction == 3) {
						while (isValid(ny, nx)) {
							if (game[ny][nx] == '#') break;
							if (game[ny][nx] == '*') {
								game[ny][nx] = '.';
								break;
							}
							nx++;
						}
					}
				}
			}
			sb.append("#").append(tt).append(" ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					sb.append(game[i][j]);
				}
				sb.append("\n");
			}
			tt++;
		}
		System.out.println(sb);
	}
}
