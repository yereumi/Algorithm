import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] tri = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j <= i; j++) {
				tri[i][j] = str.charAt(j);
			}
		}
		
		if (n < 2) {
			System.out.println(0);
			return;
		}
		
		boolean[][] visited = new boolean[n][n];
		if (tri[0][0] == 'B' || tri[1][0] == 'B' || tri[1][1] == 'B') {
			System.out.println(0);
			return;
		}
		
		visited[0][0] = visited[1][0] = visited[1][1] = true;
		
		for (int i = 2; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (visited[i][j]) continue;
				
				// 모두 R인지
				if (i + 1 >= n) continue;
				if (tri[i][j] == 'R' && tri[i + 1][j] == 'R' && tri[i + 1][j + 1] == 'R'
						&& !visited[i][j] && !visited[i + 1][j] && !visited[i + 1][j + 1]) {
					visited[i][j] = visited[i + 1][j] = visited[i + 1][j + 1] = true;
					continue;
				}
				
				// 모두 B인지
				if (j + 1 > i) {
					System.out.println(0);
					return;
				}
				if (tri[i][j] != 'B' || tri[i][j + 1] != 'B' || tri[i + 1][j + 1] != 'B'
						&& !visited[i][j] && !visited[i][j + 1] && !visited[i + 1][j + 1]) {
					System.out.println(0);
					return;
				}
				visited[i][j] = visited[i][j + 1] = visited[i + 1][j + 1] = true;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (!visited[i][j]) {
					System.out.println(0);
					return;
				}
			}
		}
		
		System.out.println(1);
		return;
	}
}
