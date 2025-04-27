import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // MaxHeap
        PriorityQueue<Integer> right = new PriorityQueue<>(); // MinHeap

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (left.size() == right.size()) {
                left.offer(num);
            } else {
                right.offer(num);
            }

            if (!right.isEmpty() && left.peek() > right.peek()) {
                int l = left.poll();
                int r = right.poll();
                left.offer(r);
                right.offer(l);
            }
            sb.append(left.peek()).append('\n');
        }
        System.out.print(sb);
	}
}