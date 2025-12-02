import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> lines = new ArrayList<>();
        lines.add(new ArrayList<>());

        Map<Integer, List<Integer>> stationToLines = new HashMap<>();

        int maxStation = 0;
        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            List<Integer> stations = new ArrayList<>();

            for (int j = 0; j < cnt; j++) {
                int s = Integer.parseInt(st.nextToken());
                maxStation = Math.max(maxStation, s);
                stations.add(s);

                stationToLines.putIfAbsent(s, new ArrayList<>());
                stationToLines.get(s).add(i);
            }

            lines.add(stations);
        }

        int d = Integer.parseInt(br.readLine());
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        Deque<Integer> dq = new ArrayDeque<>();

        for (int line : stationToLines.getOrDefault(0, new ArrayList<>())) {
            dist[line] = 0;
            dq.add(line);
        }

        while (!dq.isEmpty()) {
            int line = dq.poll();

            for (int station : lines.get(line)) {
                if (station == d) {
                    System.out.println(dist[line]);
                    return;
                }

                for (int nextLine : stationToLines.get(station)) {
                    if (dist[nextLine] > dist[line] + 1) {
                        dist[nextLine] = dist[line] + 1;
                        dq.add(nextLine);
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
