import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int t = Integer.parseInt(br.readLine());
		 List<Long> list = new ArrayList<>();
		 list.add(1L);
		 list.add(1L);
		 list.add(1L);
		 list.add(2L);
		 list.add(2L);
		 list.add(3L);
		 list.add(4L);
		 list.add(5L);
		 list.add(7L);
		 list.add(9L);
		 for (int i = 10; i < 100; i++) {
			 list.add(list.get(i - 1) + list.get(i - 5));
		 }
		 while (t-- > 0) {
			 int n = Integer.parseInt(br.readLine());
			 System.out.println(list.get(n - 1));
		 }
	}
}
 