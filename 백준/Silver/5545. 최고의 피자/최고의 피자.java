import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(br.readLine());
    	
    	Integer[] pizza = new Integer[n];
    	for (int i = 0; i < n; i++) {
    		pizza[i] = Integer.parseInt(br.readLine());
    	}
    	Arrays.sort(pizza, Collections.reverseOrder());
    	
    	int totalCal = c;
    	int totalPrice = a;
    	int answer = totalCal / totalPrice;
    	for (int i = 0; i < n; i++) {
    		totalCal += pizza[i];
            totalPrice += b;
            answer = Math.max(answer, totalCal / totalPrice);
    	}
    	
    	System.out.println(answer);
    }
}
