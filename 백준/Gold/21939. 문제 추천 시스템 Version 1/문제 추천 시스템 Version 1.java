import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // TreeMap: 난이도(L)를 키로, 문제 번호(P)의 TreeSet을 값으로 저장
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

        // 초기 입력
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            // add 명령과 동일한 처리
            map.computeIfAbsent(L, k -> new TreeSet<>()).add(P);
        }

        // 명령어 처리
        int p = Integer.parseInt(br.readLine());
        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    // 가장 어려운 문제 (난이도 가장 큰 값의 마지막 문제 번호)
                    int hardestLevel = map.lastKey();
                    int hardestProblem = map.get(hardestLevel).last();
                    sb.append(hardestProblem).append("\n");
                } else if (x == -1) {
                    // 가장 쉬운 문제 (난이도 가장 작은 값의 첫 번째 문제 번호)
                    int easiestLevel = map.firstKey();
                    int easiestProblem = map.get(easiestLevel).first();
                    sb.append(easiestProblem).append("\n");
                }
            } else if (command.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());

                // 난이도 L에 문제 번호 P 추가
                map.computeIfAbsent(L, k -> new TreeSet<>()).add(P);
            } else if (command.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());

                // 문제 번호 P를 찾고 해당 난이도에서 제거
                for (Map.Entry<Integer, TreeSet<Integer>> entry : map.entrySet()) {
                    if (entry.getValue().remove(P)) {
                        // 해당 난이도에서 문제가 비었다면 난이도 키 삭제
                        if (entry.getValue().isEmpty()) {
                            map.remove(entry.getKey());
                        }
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }
}