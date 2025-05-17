import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] nums = str.split("/");
		int k = Integer.parseInt(nums[0]);
		int d = Integer.parseInt(nums[1]);
		int a = Integer.parseInt(nums[2]);
		
		if (k + a < d || d == 0) System.out.println("hasu");
		else System.out.println("gosu");
	}
}