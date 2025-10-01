import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            String N = st.nextToken();

            if (M == 1) { // IPv8 -> 정수
                String[] parts = N.split("\\.");
                BigInteger result = BigInteger.ZERO;
                for (int i = 0; i < 8; i++) {
                    result = result.shiftLeft(8).add(BigInteger.valueOf(Integer.parseInt(parts[i])));
                }
                sb.append(result.toString()).append("\n");
            } else { // 정수 -> IPv8
                BigInteger val = new BigInteger(N);
                String[] parts = new String[8];
                for (int i = 7; i >= 0; i--) {
                    parts[i] = val.and(BigInteger.valueOf(255)).toString();
                    val = val.shiftRight(8);
                }
                sb.append(String.join(".", parts)).append("\n");
            }
        }

        System.out.print(sb);
    }
}