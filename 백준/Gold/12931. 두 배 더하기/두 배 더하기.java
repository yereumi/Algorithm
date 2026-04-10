import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        while (true) {
            boolean allZero = true;

            for (int i = 0; i < N; i++) {
                if (arr[i] % 2 == 1) {
                    arr[i]--;
                    count++;
                }
                if (arr[i] != 0) {
                    allZero = false;
                }
            }

            if (allZero) break;

            for (int i = 0; i < N; i++) {
                arr[i] /= 2;
            }
            count++;
        }

        System.out.println(count);
    }
}
