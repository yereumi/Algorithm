import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int s = Integer.parseInt(br.readLine());
		int[][] std = new int[n][2];
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			std[i][0] = Integer.parseInt(st.nextToken());
			std[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < s; i++) {
			int gen = std[i][0];
			int num = std[i][1];
			if (gen == 1) { // 남학생일 때
				for (int j = 0; j < n; j++) {
					if ((j + 1) % num == 0) { // 숫자의 배수일 때
						if (arr[j] == 0) arr[j] = 1;
						else arr[j] = 0;
					}
				}
			} else { // 여학생일 때
				int l = num - 2, r = num;
				if (arr[num - 1] == 0) arr[num - 1] = 1;
				else arr[num - 1] = 0;
				while (l >= 0 && r < n) {
					if (arr[l] != arr[r]) break;
					if (arr[l] == 0) arr[l] = arr[r] = 1;
					else arr[l] = arr[r] = 0;
					l--;
					r++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			sb.append(arr[i]).append(" ");
			if ((i + 1) % 20 == 0) sb.append("\n");
		}
		System.out.println(sb);
	}
}
