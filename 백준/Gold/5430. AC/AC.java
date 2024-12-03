import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int t = Integer.parseInt(br.readLine());
		boolean flag;
		boolean reverse;
		while (t-- > 0) {
			Deque<Integer> dq = new ArrayDeque<>();
			sb = new StringBuilder();
			flag = false;
			reverse = false;
			String str = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			if (n != 0) {
				arr = arr.substring(1, arr.length() - 1);
				String[] strArr = arr.split(",");
				for (String s : strArr) {
					dq.addLast(Integer.parseInt(s));
				}
			}
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'R') {
					reverse = !reverse;
				} else if (str.charAt(i) == 'D') {
					if (dq.isEmpty()) {
						System.out.println("error");
						flag = true;
						break;
					}
					if (!reverse) {
						dq.poll();
					} else {
						dq.removeLast();
					}
					
				}
			}
			if (!flag) {
				sb.append("[");
				while (!dq.isEmpty()) {
					if (!reverse) {
						sb.append(dq.poll());
					} else {
						sb.append(dq.removeLast());
					}
					if (!dq.isEmpty()) {
						sb.append(",");
					}
				}
				sb.append("]");
				System.out.println(sb);
			}
		}
	}
}
