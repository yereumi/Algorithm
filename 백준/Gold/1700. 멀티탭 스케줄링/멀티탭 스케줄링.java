import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	int[] electricity = new int[K];
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < K; i++) {
    		electricity[i] = Integer.parseInt(st.nextToken());
    	}
    	boolean[] visited = new boolean[K + 1];
    	int cnt = 0;
    	int answer = 0;
    	for (int i = 0; i < K; i++) {
    		int e = electricity[i];
    		
    		if (visited[e]) continue;
    		
    		if (cnt < N) {
    			visited[e] = true;
    			cnt++;
    			continue;
    		}
    		
    		Set<Integer> set = new HashSet<>();
    		for (int j = 1; j <= K; j++) {
    			if (visited[j]) set.add(j);
    		}
    		
    		int idx = i + 1;
    		while (idx < K && set.size() > 1) {
    			if (set.contains(electricity[idx]) ) {
    				set.remove(electricity[idx]);
    			}
    			idx++;
    		}
    		
    		for (int j = 1; j <= K; j++) {
    			if (set.contains(j)) {
    				visited[j] = false;
    				visited[e] = true;
    				answer++;
    				break;
    			}
    		}
    	}
    	
    	System.out.println(answer);
    }
}

/*
 * - 현재 번호가 visited 안에 있으면 넘어감
 * - 현재 번호가 visited 안에 없으면 -> 코드 빼야함
 * 	- 현재 코드 꽂혀있는 번호 중에서 하나가 남을 때까지 현재 이후 번호랑 같으면 코드 뺌
 */
