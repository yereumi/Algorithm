import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static long b;
	static int[][] block;
	
	static int simulation(int height) {
	    long remove = 0;
	    long add = 0;
	    int time = 0;

	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            int diff = block[i][j] - height;
	            if (diff > 0) {
	                remove += diff;
	                time += diff * 2;
	            } else if (diff < 0) {
	                add -= diff;
	                time += (-diff);
	            }
	        }
	    }

	    if (remove + b < add) return -1;

	    return time;
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	b = Long.parseLong(st.nextToken());
    	
    	block = new int[n][m];
    	for (int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < m; j++) {
    			block[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int maxHeight = -1;
    	int maxTime = Integer.MAX_VALUE;
    	
    	for (int i = 256; i >= 0; i--) {
    		int time = simulation(i);
    		if (time == -1) continue;
    		
    		if (time < maxTime) {
    			maxHeight = i;
    			maxTime = time;
    		}
    	}
    	
    	System.out.println(maxTime + " " + maxHeight);
    }
}
