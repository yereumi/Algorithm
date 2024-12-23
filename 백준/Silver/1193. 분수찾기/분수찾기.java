import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());

		int total = 0;
		int i = 0;
		int s, m;
		while (total < x) {
			i++;
			total += i;
		}
		total -= i;
		i--;
		if (i % 2 == 0) {
			s = i + 1;;
			m = 1;
			while (total != x - 1) {
				s--;
				m++;
				total++;
			}
		} else {
			s = 1;
			m = i + 1;
			while (total != x - 1) {
				s++;
				m--;
				total++;
			}
			
		}
		System.out.println(s + "/" + m);
	}
}
