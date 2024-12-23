import java.util.*;
import java.io.*;

public class Main {

	public static int n, m, min;
	public static int[][] arr;
	public static List<int[]> home;
	public static List<int[]> chicken;
	public static boolean[] selectedChicken;

	public static int calculateMin() {
		int sum = 0;
		for (int[] pointH : home) {
			int distance = n * n;
			for (int i = 0; i < chicken.size(); i++) {
				if (selectedChicken[i]) {
					distance = Math.min(distance, Math.abs(chicken.get(i)[0] - pointH[0]) + Math.abs(chicken.get(i)[1] - pointH[1]));
				}
			}
			sum += distance;
		}
		return sum;
	}
	
	public static void recursive(int depth, int start) {
		if (depth == m) {
			min = Math.min(min, calculateMin());
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			if (!selectedChicken[i]) {
				selectedChicken[i] = true;
				recursive(depth + 1, i + 1);
				selectedChicken[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		min = n * n * n;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					home.add(new int[] { i, j });
				if (arr[i][j] == 2)
					chicken.add(new int[] { i, j });
			}
		}
		
		selectedChicken = new boolean[chicken.size()];
		recursive(0, 0);
		System.out.println(min);
	}
}
