import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int[] mom = new int[N + 1];
        int[] dad = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            mom[i] = Integer.parseInt(st.nextToken());
            dad[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine().trim());
        boolean[] alive = new boolean[N + 1];
        Arrays.fill(alive, true);

        String line = br.readLine();
        if (line == null) line = "";
        StringTokenizer st = new StringTokenizer(line);
        for (int i = 0; i < M; i++) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            int v = Integer.parseInt(st.nextToken());
            alive[v] = false;
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (!alive[i]) continue;
            int m = mom[i], d = dad[i];
            if (m == 0 || d == 0) continue;
            if (alive[m] && alive[d]) ans++;
        }

        System.out.println(ans);
    }
}
