import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] town = new int[n][2];
        long total = 0;
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	town[i][0] = Integer.parseInt(st.nextToken());
        	town[i][1] = Integer.parseInt(st.nextToken());
        	total += town[i][1];
        }
        
        Arrays.sort(town, ((o1, o2) -> o1[0] - o2[0]));
        long sum = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
        	sum += town[i][1];
        	answer = town[i][0];
        	
        	if (sum >= (total + 1) / 2) {
        			System.out.println(answer);
            		break;
        	}
        }
    }
}
