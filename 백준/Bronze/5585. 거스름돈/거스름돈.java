import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int change = 1000 - n;
		cnt = change / 500 + (change % 500) / 100 + (change % 100) / 50 + (change % 50) / 10 + (change % 10) / 5 + (change % 5) / 1;
		System.out.println(cnt);
	}
}
