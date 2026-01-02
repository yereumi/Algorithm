import java.io.*;
import java.util.*;

public class Main {
	
	static int chooseSeat(List<Integer> occupied, int n) {
        Collections.sort(occupied);

        int bestSeat = 1;
        int bestDist = occupied.get(0) - 1;

        for (int i = 1; i < occupied.size(); i++) {
            int left = occupied.get(i - 1);
            int right = occupied.get(i);
            int mid = (left + right) / 2;
            int dist = Math.min(mid - left, right - mid);

            if (dist > bestDist || (dist == bestDist && mid < bestSeat)) {
                bestDist = dist;
                bestSeat = mid;
            }
        }

        int rightDist = n - occupied.get(occupied.size() - 1);
        if (rightDist > bestDist) {
            bestSeat = n;
        }

        return bestSeat;
    }

    static int toMinute(String s) {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(2, 4));
        return (h - 9) * 60 + m;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        boolean[][] times = new boolean[n + 1][721];
        String[][] reservations = new String[t][2];

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            reservations[i][0] = st.nextToken();
            reservations[i][1] = st.nextToken();
        }

        Arrays.sort(reservations, (o1, o2) -> {
            int cmp = o1[0].compareTo(o2[0]);
            if (cmp != 0) return cmp;
            return o1[1].compareTo(o2[1]);
        });

        for (int i = 0; i < t; i++) {
            int startTime = toMinute(reservations[i][0]);
            int endTime   = toMinute(reservations[i][1]);

            List<Integer> occupied = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (times[j][startTime]) occupied.add(j);
            }

            int seatToUse;

            if (occupied.isEmpty()) seatToUse = 1;
            else seatToUse = chooseSeat(occupied, n);

            for (int m = startTime; m < endTime; m++) {
                times[seatToUse][m] = true;
            }
        }

        int time = 0;
        for (int i = 0; i < 720; i++) {
            if (!times[p][i]) time++;
        }

        System.out.println(time);
    }
}
