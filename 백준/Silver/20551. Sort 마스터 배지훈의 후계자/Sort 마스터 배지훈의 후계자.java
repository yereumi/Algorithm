import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int D = Integer.parseInt(br.readLine());
            int idx = lowerBound(A, D);

            if (idx < N && A[idx] == D) sb.append(idx).append("\n");
            else sb.append(-1).append("\n");
        }

        System.out.print(sb);
    }

    static int lowerBound(int[] arr, int key) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < key) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}