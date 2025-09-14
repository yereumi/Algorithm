import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<String, Integer> score = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            score.put(s, p);
        }

        long fixed = 0;
        Set<String> published = new HashSet<>();
        for (int i = 0; i < K; i++) {
            String t = br.readLine().trim();
            published.add(t);
            fixed += score.get(t);
        }

        List<Integer> rest = new ArrayList<>();
        for (Map.Entry<String, Integer> e : score.entrySet()) {
            if (!published.contains(e.getKey())) rest.add(e.getValue());
        }
        Collections.sort(rest);

        int need = M - K;
        long min = fixed, max = fixed;
        for (int i = 0; i < need; i++) min += rest.get(i);
        for (int i = 0; i < need; i++) max += rest.get(rest.size() - 1 - i);

        System.out.println(min + " " + max);
    }
}