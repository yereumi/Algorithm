import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] assignment = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			assignment[i][0] = Integer.parseInt(st.nextToken());
			assignment[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(assignment, (o1, o2) -> {
			if (o1[1] != o2[1]) return o2[1] - o1[1];
			return o1[0] - o2[0];
		});
		
		boolean[] check = new boolean[1001];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int[] cur = assignment[i];
			for (int j = cur[0]; j > 0; j--) { 
				if (!check[j]) {
					sum += cur[1];
					check[j] = true;
					break;
				}
			}
		}
		
		System.out.println(sum);
	}
}
