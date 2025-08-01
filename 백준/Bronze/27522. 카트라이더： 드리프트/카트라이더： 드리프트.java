import java.util.*;

public class Main {
    static class Racer implements Comparable<Racer> {
        int time;
        char team;

        Racer(String timeStr, char team) {
            this.time = parseTime(timeStr);
            this.team = team;
        }

        private int parseTime(String timeStr) {
            String[] parts = timeStr.split("[:]");
            int min = Integer.parseInt(parts[0]);
            int sec = Integer.parseInt(parts[1]);
            int ms = Integer.parseInt(parts[2]);
            return (min * 60 * 1000) + (sec * 1000) + ms;
        }

        @Override
        public int compareTo(Racer o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Racer> racers = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            String[] parts = sc.next().split(":|\\s+");
            String timeStr = parts[0] + ":" + parts[1] + ":" + parts[2];
            char team = sc.next().charAt(0);
            racers.add(new Racer(timeStr, team));
        }

        Collections.sort(racers);

        int[] scores = {10, 8, 6, 5, 4, 3, 2, 1};
        int red = 0, blue = 0;

        for (int i = 0; i < 8; i++) {
            if (racers.get(i).team == 'R') red += scores[i];
            else blue += scores[i];
        }

        if (red > blue) System.out.println("Red");
        else if (blue > red) System.out.println("Blue");
        else {
            for (int i = 0; i < 8; i++) {
                if (racers.get(i).team == 'R') {
                    System.out.println("Red");
                    break;
                } else if (racers.get(i).team == 'B') {
                    System.out.println("Blue");
                    break;
                }
            }
        }
    }
}