import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n * 2 + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	num[i] = num[i + n] = Integer.parseInt(st.nextToken());
        }
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
        	if (num[i] >= num[i + 1]) cnt++;
        }
        System.out.println(cnt);
    }
}