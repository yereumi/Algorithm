import java.io.*;
import java.util.*;

public class Main {
	
	static long n, p, q;
	static Map<Long, Long> map;
	
	static long solve(long x) {		
		if (x == 0) return 1L;
		
		Long value = map.get(x);
		if (value != null) return value;
		
		long result = solve(x / p) + solve(x / q);
		map.put(x, result);
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		p = Long.parseLong(st.nextToken());
		q = Long.parseLong(st.nextToken());
		map = new HashMap<>();
		
	
		System.out.println(solve(n));
	}
}