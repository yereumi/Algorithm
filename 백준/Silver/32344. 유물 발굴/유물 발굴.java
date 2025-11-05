import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        int[] minRow = new int[N + 1];
        int[] maxRow = new int[N + 1];
        int[] minCol = new int[N + 1];
        int[] maxCol = new int[N + 1];
        boolean[] exists = new boolean[N + 1];

        Arrays.fill(minRow, Integer.MAX_VALUE);
        Arrays.fill(minCol, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            exists[a] = true;
            minRow[a] = Math.min(minRow[a], v);
            maxRow[a] = Math.max(maxRow[a], v);
            minCol[a] = Math.min(minCol[a], h);
            maxCol[a] = Math.max(maxCol[a], h);
        }

        int bestId = -1;
        long bestArea = -1;

        for (int i = 1; i <= N; i++) {
            if (!exists[i]) continue;
            long height = maxRow[i] - minRow[i] + 1;
            long width = maxCol[i] - minCol[i] + 1;
            long area = height * width;

            if (area > bestArea || (area == bestArea && i < bestId)) {
                bestArea = area;
                bestId = i;
            }
        }

        System.out.println(bestId + " " + bestArea);
    }
}
