import java.io.*;
import java.util.*;

public class Main {

    static long pow(long a, long b, long c) {
        if (b == 1) return a % c;

        long half = pow(a, b / 2, c);
        long result = (half * half) % c;

        if (b % 2 == 1) {
            result = (result * a) % c;
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B, C));
    }
}
