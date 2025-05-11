import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		for (int i = 0; i < 3; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num <= n) answer += num;
			else answer += n;
		}
		System.out.println(answer);
	}
}