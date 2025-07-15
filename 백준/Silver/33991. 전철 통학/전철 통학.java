import java.io.*;
import java.util.*;

public class Main {

    public static int nextTrainTime(int distance, int interval) {
        return ((distance + interval - 1) / interval) * interval;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X1 = Integer.parseInt(st.nextToken());
        int Y1 = Integer.parseInt(st.nextToken());
        int X2 = Integer.parseInt(st.nextToken());
        int Y2 = Integer.parseInt(st.nextToken());
        int X3 = Integer.parseInt(st.nextToken());
        int Y3 = Integer.parseInt(st.nextToken());

        int Q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int T1 = Integer.parseInt(st.nextToken());
            int T2 = Integer.parseInt(st.nextToken());
            int T3 = Integer.parseInt(st.nextToken());

            int d1 = Math.abs(X - X1) + Math.abs(Y - Y1);
            int d2 = Math.abs(X - X2) + Math.abs(Y - Y2);
            int d3 = Math.abs(X - X3) + Math.abs(Y - Y3);

            int t1 = nextTrainTime(d1, T1);
            int t2 = nextTrainTime(d2, T2);
            int t3 = nextTrainTime(d3, T3);

            int result = Math.min(t1, Math.min(t2, t3));
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}