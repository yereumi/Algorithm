import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int answer = 0;
        for (int i = 0; i < l; i++) {
        	answer += Math.pow(31, i) * (str.charAt(i) - 'a' + 1);
        	answer %= 1234567891;
        }
        System.out.println(answer);
    }
}
