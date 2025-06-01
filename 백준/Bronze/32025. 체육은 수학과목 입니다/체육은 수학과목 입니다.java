import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int h = Integer.parseInt(br.readLine());
		int w = Integer.parseInt(br.readLine());
		
		if (h < w) System.out.println(h * 50);
		else System.out.println(w * 50);
	}
}