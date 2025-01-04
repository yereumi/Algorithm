import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int r = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
	}
}
