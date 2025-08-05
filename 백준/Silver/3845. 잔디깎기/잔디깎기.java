import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static final double EPS = 1e-8;
    static final double WIDTH_X = 75.0;
    static final double WIDTH_Y = 100.0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());
            double w = Double.parseDouble(st.nextToken());

            if (nx == 0 && ny == 0 && Math.abs(w) < EPS) {
                break;  // 종료 조건
            }

            double h = w / 2.0;
            List<double[]> segX = new ArrayList<>();
            List<double[]> segY = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < nx; i++) {
                double x = Double.parseDouble(st.nextToken());
                double L = Math.max(0.0, x - h);
                double R = Math.min(WIDTH_X, x + h);
                segX.add(new double[]{L, R});
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < ny; i++) {
                double y = Double.parseDouble(st.nextToken());
                double L = Math.max(0.0, y - h);
                double R = Math.min(WIDTH_Y, y + h);
                segY.add(new double[]{L, R});
            }

            boolean okX = coversFull(segX, WIDTH_X);
            boolean okY = coversFull(segY, WIDTH_Y);

            System.out.println((okX && okY) ? "YES" : "NO");
        }
    }

    static boolean coversFull(List<double[]> segs, double limit) {
        Collections.sort(segs, (a, b) -> {
            if (Math.abs(a[0] - b[0]) > EPS) return a[0] < b[0] ? -1 : 1;
            return Double.compare(a[1], b[1]);
        });

        double covered = 0.0;
        for (double[] s : segs) {
            if (s[0] > covered + EPS) {
                return false;
            }
            covered = Math.max(covered, s[1]);
            if (covered >= limit - EPS) {
                return true;
            }
        }
        return covered >= limit - EPS;
    }
}