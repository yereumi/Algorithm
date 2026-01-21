import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] top = new int[N];
        int[] bot = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) top[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) bot[i] = Integer.parseInt(st.nextToken());

        boolean up = true;
        boolean down = false;

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            boolean newUp = false;
            boolean newDown = false;

            if (up && top[i] == 1) newUp = true;
            if (down && bot[i] == 1) newDown = true;

            if (up && bot[i] == 1 && top[i] == 1) newDown = true;
            if (down && top[i] == 1 && bot[i] == 1) newUp = true;

            up = newUp;
            down = newDown;

            if (up || down) {
                int cost = 0;
                if (top[i] == 1) cost++;
                if (bot[i] == 1) cost++;
                answer = Math.min(answer, cost);
            }
        }

        if (!up && !down) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
