import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long answer = 0;
        for (int i = l - 1; i >= 0; i--) {
        	answer *= 31;
        	answer %= 1234567891;
        	answer += str.charAt(i) - 'a' + 1;
        }
        System.out.println(answer);
    }
}
