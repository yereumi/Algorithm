import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] money = { 50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10 };

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	int[] answer = new int[money.length];
        	for (int m = 0; m < money.length; m++) {
        		answer[m] = N / money[m];
        		N %= money[m];
        	}
        	
        	sb.append("#" + t).append('\n');
        	for (int i : answer) {
        		sb.append(i + " ");
        	}
        	sb.append('\n');
        }
        
        System.out.println(sb.toString());
    }
}
