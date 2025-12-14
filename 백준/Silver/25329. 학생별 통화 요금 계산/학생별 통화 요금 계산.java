import java.io.*;
import java.util.*;

public class Main {
    static int fee(int minutes) {
        if (minutes <= 100) return 10;
        int extra = minutes - 100;
        return 10 + ((extra + 49) / 50) * 3;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        Map<String, Integer> time = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            String name = st.nextToken();
            int h = Integer.parseInt(t.substring(0, 2));
            int m = Integer.parseInt(t.substring(3, 5));
            time.put(name, time.getOrDefault(name, 0) + h * 60 + m);
        }

        List<String> names = new ArrayList<>(time.keySet());
        names.sort((a, b) -> {
            int fa = fee(time.get(a));
            int fb = fee(time.get(b));
            if (fa != fb) return fb - fa;
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name).append(" ").append(fee(time.get(name))).append("\n");
        }
        System.out.print(sb.toString());
    }
}
