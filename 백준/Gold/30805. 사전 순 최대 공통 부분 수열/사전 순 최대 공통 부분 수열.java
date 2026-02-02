import java.io.*;
import java.util.*;

public class Main {

    static int findNext(int[] arr, int start, int value) {
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> answer = new ArrayList<>();

        int aPos = 0;
        int bPos = 0;

        while (true) {
            int chosenValue = -1;
            int nextA = -1;
            int nextB = -1;

            for (int v = 100; v >= 1; v--) {
                int i = findNext(A, aPos, v);
                int j = findNext(B, bPos, v);

                if (i != -1 && j != -1) {
                    chosenValue = v;
                    nextA = i;
                    nextB = j;
                    break;
                }
            }

            if (chosenValue == -1) break;

            answer.add(chosenValue);
            aPos = nextA + 1;
            bPos = nextB + 1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append('\n');
        if (!answer.isEmpty()) {
            for (int x : answer) {
                sb.append(x).append(' ');
            }
        }

        System.out.print(sb.toString());
    }
}
