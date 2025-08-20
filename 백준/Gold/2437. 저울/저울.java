import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		int continuousMax = 0;
		int idx = 0;
		while (idx < n) {
			if (num[idx] <= continuousMax + 1) {
				continuousMax += num[idx];
			} else {
				break;
			}
			idx++;
		}
		System.out.println(continuousMax + 1);
    }
}