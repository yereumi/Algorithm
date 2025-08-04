import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int K = sc.nextInt();
            for (int j = 0; j < K; j++) {
                String id = sc.next();
                count.put(id, count.getOrDefault(id, 0) + 1);
            }
        }

        int result = 0;
        for (int c : count.values()) {
            if (c >= M) result++;
        }

        System.out.println(result);
    }
}