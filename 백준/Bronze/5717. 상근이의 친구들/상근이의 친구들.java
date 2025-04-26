import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
        	int f = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (f == 0 && m == 0) break;
            System.out.println(f + m);
        }
    }
}