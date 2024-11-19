import java.util.*;
import java.io.*;

public class Main {
	
	public static int k, n;
	public static int[] array;
	
	public static boolean isPossible(long target) {
		long cnt = 0;
		for (int i : array) {
			cnt += i / target;
		}
		return cnt >= n; // mid값이 원하는 범위 안에 있음 
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		array = new int[k];
		long l = 1, r = 0;
		for (int i = 0; i < k; i++) {
			array[i] = Integer.parseInt(br.readLine());
			r = Math.max(r, array[i]);
		}
//		Arrays.sort(array); // list.sort((o1, o2) -> o1.compareTo(o2)) -> Object 타입에만 적용 가능
		// 매개변수 탐색 요소: 1. 매개변수(mid), 2. 결정함수(if문 조건식)
		while (l <= r) {
			long mid = (l + r) / 2;
			if (isPossible(mid)) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
//		System.out.println(l);
		System.out.println(r);
	}
}
