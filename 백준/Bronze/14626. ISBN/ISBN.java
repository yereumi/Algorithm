import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String isbn = br.readLine();

        int sum = 0;
        int starIdx = -1;

        int m = isbn.charAt(12) - '0';

        for (int i = 0; i < 12; i++) {
            char c = isbn.charAt(i);
            if (c == '*') {
                starIdx = i;
                continue;
            }
            int digit = c - '0';
            int weight = (i % 2 == 0) ? 1 : 3;
            sum += digit * weight;
        }

        int starWeight = (starIdx % 2 == 0) ? 1 : 3;

        for (int x = 0; x <= 9; x++) {
            if ((sum + x * starWeight + m) % 10 == 0) {
                System.out.println(x);
                break;
            }
        }
    }
}
