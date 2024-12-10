import java.util.*;
import java.io.*;

public class Main {
	
	private static int convertBaseToDecimal(String num, int base) {
        int decimal = 0;
        int power = 1; 

        for (int i = num.length() - 1; i >= 0; i--) {
            int digit; 
            char curr = num.charAt(i); 

            if (curr >= '0' && curr <= '9') { 
                digit = curr - '0';
            } else { 
                digit = curr + 10 - 'A';
            }
            decimal += digit * power;
            power *= base;
        }

        return decimal;
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		System.out.println(convertBaseToDecimal(n, b));
	}
}
