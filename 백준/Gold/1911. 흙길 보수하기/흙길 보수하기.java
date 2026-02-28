import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] water = new int[N][2];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	water[i][0] = Integer.parseInt(st.nextToken());
        	water[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }
        
        Arrays.sort(water, (o1, o2) -> 
        	o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1]);
        
        int prev = water[0][1] + 1;
        int idx = 0;
        int cnt = 0;
        while (prev >= 0 && idx < N) {
        	int len = (water[idx][1] - water[idx][0]) + 1; 
        	
        	if (water[idx][1] >= prev) {
        		len = prev - 1 - water[idx][0] + 1;
        	}
        	
        	if (prev < water[idx][0]) {
        		idx++;
        		continue;
        	}
        	
        	if (len % L != 0) {
        		cnt++;
            	prev = water[idx][0] - (L - len % L);
        	} else {
        		prev = water[idx][0];
        	}
        	cnt += len / L;
        	idx++;        	
        }
        
        System.out.println(cnt);
    }
}
