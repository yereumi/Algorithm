import java.util.*;
import java.io.*;

public class Main {
    
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = read();
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch (s) {
				case "push" : {
					int num = Integer.parseInt(st.nextToken());
					dq.offer(num);
					break;
				}
				case "pop" :
					if (!dq.isEmpty()) sb.append(dq.poll()).append("\n");
					else sb.append(-1).append("\n");
					break;
				case "size" :
					sb.append(dq.size()).append("\n"); break;
				case "empty" :
					if (dq.isEmpty()) sb.append("1").append("\n");
					else sb.append("0").append("\n");
					break;
				case "front" :
					if (!dq.isEmpty()) sb.append(dq.peek()).append("\n");
					else sb.append(-1).append("\n");
					break;
				case "back" :
					if (!dq.isEmpty()) sb.append(dq.peekLast()).append("\n");
					else sb.append(-1).append("\n");
					break;
			}
		}
		System.out.println(sb);
	}
}
