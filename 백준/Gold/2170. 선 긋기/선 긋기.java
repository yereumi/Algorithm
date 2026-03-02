import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[][] line = new int[N][2];
    	StringTokenizer st;
    	
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		line[i][0] = Integer.parseInt(st.nextToken());
    		line[i][1] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(line, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
    	
    	long answer = 0;
    	long prev = Long.MIN_VALUE;
    	
    	for (int i = 0; i < N; i++) {
    		if (prev <= line[i][0]) {
    			answer += line[i][1] - line[i][0];
    		} else {
    			if (line[i][1] <= prev) continue;
    			answer += line[i][1] - prev;
    		}
    		
    		prev = line[i][1];
    	}
    	
    	System.out.println(answer);
    }
}
