import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n - 1; i++) {
			pq.offer(num[i + 1] - num[i]);
		}
		int result = 0;
		for (int i = 0; i < n - k; i++) {
			result += pq.poll();
		}
		System.out.println(result);
	}
}
