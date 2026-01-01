import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Deque<int[]> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int h = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek()[1] < h) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(stack.peek()[0]).append(" ");
            }

            stack.push(new int[]{i, h});
        }

        System.out.println(sb.toString().trim());
	}
}
