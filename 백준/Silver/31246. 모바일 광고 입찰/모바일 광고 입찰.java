import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] ad = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ad[i][0] = Integer.parseInt(st.nextToken());
			ad[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ad, (o1, o2) -> (o2[0] - o2[1]) - (o1[0] - o1[1]));
		if (ad[k - 1][0] - ad[k - 1][1] >= 0) System.out.println(0);
		else System.out.println(ad[k - 1][1] - ad[k - 1][0]);
	}
}
