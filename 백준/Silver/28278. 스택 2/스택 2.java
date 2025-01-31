import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int n = Integer.parseInt(br.readLine());
		 Deque<Integer> dq = new ArrayDeque<>();
		 while (n-- > 0) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 int f = Integer.parseInt(st.nextToken());
			 if (f == 1) {
				 int num = Integer.parseInt(st.nextToken());
				 dq.push(num);
			 } else if (f == 2) {
				 if (!dq.isEmpty()) {
					 System.out.println(dq.pop());
				 } else { System.out.println(-1); }
			 } else if (f == 3) {
				 System.out.println(dq.size());
			 } else if (f == 4) {
				 if (dq.isEmpty()) System.out.println(1);
				 else System.out.println(0);
			 } else if (f == 5) {
				 if (!dq.isEmpty()) {
					 System.out.println(dq.peek());
				 } else { System.out.println(-1); }
			 }
		 }    
	}
}
