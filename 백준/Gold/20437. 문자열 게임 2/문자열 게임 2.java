import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	while (T-- > 0) {
    		String word = br.readLine();
    		int K = Integer.parseInt(br.readLine());
    		
    		Map<Character, List<Integer>> map = new HashMap<>();
    		
    		for (int i = 0; i < word.length(); i++) {
    			char c = word.charAt(i);
    			List<Integer> idx = map.getOrDefault(c, new ArrayList<>());
    			idx.add(i);
    			map.put(c, idx);
    		}
    		
    		int min = Integer.MAX_VALUE;
    		int max = Integer.MIN_VALUE;
    		
    		for (List<Integer> list : map.values()) {
    			if (list.size() < K) continue;
    			
    		    for (int i = 0; i + K - 1 < list.size(); i++) {
    		        int start = list.get(i);
    		        int end = list.get(i + K - 1);
    		        int len = end - start + 1;
    		        
    		        min = Math.min(min, len);
    		        max = Math.max(max, len);
    		    }
    		}
    		
    		if (min == Integer.MAX_VALUE) sb.append(-1).append("\n");
    		else sb.append(min + " " + max).append("\n");
    	}
    	
    	System.out.println(sb.toString());
    }
}
