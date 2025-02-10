import java.util.*;
import java.io.*;

public class Main {

	private static long read() throws Exception {
		long c, n = System.in.read() & 15;
		boolean m = n == 13;
		if (m)
			n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return m ? ~n + 1 : n;
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int n = (int) read();
		long[] arr = new long[n];
		int[] arrIdx = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = read();
		}
		List<Long> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int idx = Collections.binarySearch(list, arr[i]);
			if (idx < 0)
				idx = Math.abs(idx) - 1;
			if (list.isEmpty() || list.get(list.size() - 1) < arr[i])
				list.add(arr[i]);
			else {
				list.set(idx, arr[i]);
			}
			arrIdx[i] = idx;
		}
		int cnt = list.size();
		sb.append(cnt).append("\n");
		List<Long> result = new ArrayList<>();
		int maxLISLength = cnt;
        for (int i = n - 1; i >= 0; i--) {
            if (arrIdx[i] == maxLISLength - 1) {
                result.add(arr[i]);
                maxLISLength--;
            }
        }
		Collections.reverse(result);
		for (int i = 0; i < result.size(); i++) sb.append(result.get(i)).append(" ");
		System.out.println(sb);
	}
}
