import java.util.*;
import java.io.*;

public class Main {
    
	static int m, min;
	static int[][] house, chicken;
	static boolean[] visited;

	private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
	
	public static int calculateMin() {
		int min = 0;
		for (int[] h : house) {
			int distance = Integer.MAX_VALUE;
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					distance = Math.min(distance, Math.abs(chicken[i][0] - h[0]) + Math.abs(chicken[i][1] - h[1]));
				}
			}
			min += distance;
		}
		return min;
	}
	
	public static int recursive(int depth, int start) {
		if (depth == m) {
			return Math.min(min, calculateMin());
		}
		for (int i = start; i < chicken.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				min = recursive(depth + 1, i + 1);
				visited[i] = false;
			}
		}
		return min;
	}

	public static void main(String[] args) throws Exception {
		int n = read();
		m = read();
		int[][] arr = new int[n][n];
		int hCnt = 0, cCnt = 0;
		
		int hIdx = 0, cIdx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = read();
				if (arr[i][j] == 1) hCnt++;
				if (arr[i][j] == 2) cCnt++;
			}
		}
		house = new int[hCnt][2];
		chicken = new int[cCnt][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					house[hIdx][0] = i; house[hIdx++][1] = j;
				}
				if (arr[i][j] == 2) {
					chicken[cIdx][0] = i; chicken[cIdx++][1] = j;
				}
			}
		}
		min = Integer.MAX_VALUE;
		visited = new boolean[chicken.length];
		System.out.println(recursive(0, 0));
	}
}
