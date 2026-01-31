import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] blocked = new boolean[N + 1];

        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int x = Integer.parseInt(st.nextToken());
                blocked[x] = true;
            }
        }

        for (int K = 1; K < N; K++) {
            boolean[] visited = new boolean[N + 1];
            int cur = 1;
            boolean ok = true;

            while (!visited[cur]) {
                visited[cur] = true;

                if (cur == Z) {
                    System.out.println(K);
                    return;
                }

                if (blocked[cur]) {
                    ok = false;
                    break;
                }

                cur = (cur + K - 1) % N + 1;
            }
        }
    }
}
