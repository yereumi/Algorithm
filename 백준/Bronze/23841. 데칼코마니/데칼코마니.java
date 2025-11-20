import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int half = M / 2;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            char[] res = new char[M];

            for (int j = 0; j < half; j++) {
                char L = row.charAt(j);
                char R = row.charAt(M - 1 - j);

                res[j] = (L != '.') ? L : R;
                res[M - 1 - j] = (R != '.') ? R : L;
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }
}