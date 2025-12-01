import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {

            int[] A = new int[5];
            int[] B = new int[5];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int i = 0; i < a; i++) {
                int x = Integer.parseInt(st.nextToken());
                A[x]++;
            }

            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for (int i = 0; i < b; i++) {
                int x = Integer.parseInt(st.nextToken());
                B[x]++;
            }

            char result = 'D';
            for (int shape = 4; shape >= 1; shape--) {
                if (A[shape] > B[shape]) {
                    result = 'A';
                    break;
                } else if (A[shape] < B[shape]) {
                    result = 'B';
                    break;
                }
            }

            System.out.println(result);
        }
    }
}
