import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine().trim();

        int chicken = 0;
        for (char ch : S.toCharArray()) {
            if (ch == 'C') chicken++;
        }

        int others = N - chicken;
        int groups = others + 1;

        int result = (int) Math.ceil((double) chicken / groups);
        System.out.println(result);
    }
}
