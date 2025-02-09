import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long d = Long.parseLong(st.nextToken());
		long[][] present = new long[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			present[i][0] = Long.parseLong(st.nextToken());
			present[i][1] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(present, (o1, o2) -> {
			if (o1[0] != o2[0])
				return Long.compare(o1[0], o2[0]);
			return Long.compare(o1[1], o2[1]);
		});
		int l = 0;
        long sum = 0, maxSum = 0;
        for (int r = 0; r < n; r++) {
            sum += present[r][1];
            while (present[r][0] - present[l][0] >= d) {
                sum -= present[l][1];
                l++;
            }
            maxSum = Math.max(maxSum, sum);
        }

		System.out.println(maxSum);
		br.close();
	}
}
