import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        StringBuilder out = new StringBuilder();

        for (int x = 1; x <= 10; x++) {
            boolean any = false;
            StringBuilder line = new StringBuilder();
            for (int y = 1; y <= 10; y++) {
                if (A * x + B * y == C) {
                    if (any) line.append(' ');
                    line.append(y);
                    any = true;
                }
            }
            if (!any) out.append('0').append('\n');
            else out.append(line).append('\n');
        }

        System.out.print(out.toString());
    }
}