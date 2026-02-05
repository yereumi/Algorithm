import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static Set<String> nameSet;
	static Map<String, int[]> timeMap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nameSet = new HashSet<>();
		timeMap = new HashMap<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			String place = st.nextToken();
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());
			
			if (nameSet.contains(name)) continue;
			
			nameSet.add(name);
			int[] time = timeMap.getOrDefault(place, new int[50001]);
			for (int j = startTime; j < endTime; j++) {
				time[j]++;
			}
			
			timeMap.put(place, time);
		}
		
		PriorityQueue<String[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (Integer.parseInt(o1[3]) != Integer.parseInt(o2[3])) return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
			if (!o1[0].equals(o2[0])) return o1[0].compareTo(o2[0]);
			if (Integer.parseInt(o1[1]) != Integer.parseInt(o2[1])) return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
			return (Integer.parseInt(o2[2]) - Integer.parseInt(o2[1])) - (Integer.parseInt(o1[2]) - Integer.parseInt(o1[1]));
		});
		
		for (Map.Entry<String, int[]> entry : timeMap.entrySet()) {
		    String key = entry.getKey();
		    int[] value = entry.getValue();
		    
		    int max = 0;
		    for (int i = 1; i < value.length; i++) {
		    	if (value[i] > max) {
		    		max = value[i];
		    	}
		    }
		    
		    for (int i = 1; i < value.length; i++) {
		    	if (i < value.length && value[i] == max) {
		    		int start = i;
		    		while (value[i] == max) i++;
		    		int end = i;
		    		
		    		pq.offer(new String[] { key, String.valueOf(start), String.valueOf(end), String.valueOf(max) });
		    	}
		    }
		}
		
		String[] answer = pq.poll();
		System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
		
		br.close();
	}
}
