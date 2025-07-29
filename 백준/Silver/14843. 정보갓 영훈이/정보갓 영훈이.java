import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 푼 문제 수
        double total = 0.0;

        for (int i = 0; i < N; i++) {
            double S = sc.nextDouble(); // 별 개수
            int A = sc.nextInt();       // 시도 횟수
            int T = sc.nextInt();       // 구동 시간
            int M = sc.nextInt();       // 최단 구동 시간

            double score = S * (1.0 + 1.0 / A) * (1.0 + (double) M / T) / 4.0;
            total += score;
        }

        int P = sc.nextInt(); // 비교 대상 수
        double[] others = new double[P];

        for (int i = 0; i < P; i++) {
            others[i] = sc.nextDouble();
        }

        List<Double> scores = new ArrayList<>();
        for (double s : others) {
            scores.add(s);
        }
        scores.add(total);

        scores.sort(Collections.reverseOrder());

        int rank = scores.indexOf(total) + 1;

        int cutoff = (int) ((P + 1) * 0.15);

        if (rank <= cutoff) {
            System.out.printf("The total score of Younghoon \"The God\" is %.2f.\n", total);
        } else {
            System.out.printf("The total score of Younghoon is %.2f.\n", total);
        }
    }
}