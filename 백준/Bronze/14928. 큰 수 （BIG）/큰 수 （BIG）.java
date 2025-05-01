import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
        int remainder = 0;
        for (int i = 0; i < s.length(); i++) {
            remainder = (int)((remainder * 10L + (s.charAt(i) - '0')) % 20000303);
        }
        System.out.println(remainder);
	}
}