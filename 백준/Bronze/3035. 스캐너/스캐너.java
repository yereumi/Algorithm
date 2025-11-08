import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int ZR = Integer.parseInt(st.nextToken());
        int ZC = Integer.parseInt(st.nextToken());

        StringBuilder out = new StringBuilder();

        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            StringBuilder scaledRow = new StringBuilder(C * ZC);
            for (int c = 0; c < C; c++) {
                char ch = line.charAt(c);
                for (int k = 0; k < ZC; k++) scaledRow.append(ch);
            }
            String rowStr = scaledRow.toString();
            for (int t = 0; t < ZR; t++) out.append(rowStr).append('\n');
        }

        System.out.print(out.toString());
    }
}