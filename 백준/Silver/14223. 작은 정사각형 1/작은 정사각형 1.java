import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        long x, y;
        Point(long x, long y) { this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point[] p = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            p[i] = new Point(x, y);
        }

        long ans = Long.MAX_VALUE;

        ans = Math.min(ans, calc(p, null, null));

        for (int i = 0; i < N; i++) {
            ans = Math.min(ans, calc(p, i, null));
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                ans = Math.min(ans, calc(p, i, j));
            }
        }

        System.out.println(ans);
    }

    static long calc(Point[] p, Integer skip1, Integer skip2) {
        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;

        int cnt = 0;
        for (int i = 0; i < p.length; i++) {
            if ((skip1 != null && i == skip1) || (skip2 != null && i == skip2)) continue;
            cnt++;
            minX = Math.min(minX, p[i].x);
            maxX = Math.max(maxX, p[i].x);
            minY = Math.min(minY, p[i].y);
            maxY = Math.max(maxY, p[i].y);
        }

        long dx = maxX - minX;
        long dy = maxY - minY;
        long side = Math.max(dx, dy) + 2;

        return side * side;
    }
}
