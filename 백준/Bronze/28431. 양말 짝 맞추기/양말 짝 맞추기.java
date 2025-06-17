import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			int n = Integer.parseInt(br.readLine());
			int count = map.getOrDefault(n, 0);
            map.put(n, count + 1);
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                System.out.println(entry.getKey());
                break;
            }
        }
	}
}