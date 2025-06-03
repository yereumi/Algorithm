import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 전체 카드 수
        int M = Integer.parseInt(input[1]); // 앞면 O 카드 수
        int K = Integer.parseInt(input[2]); // 뒷면 O로 쓸 개수

        int frontO = M;
        int frontX = N - M;
        int backO = K;
        int backX = N - K;

        int matchedO = Math.min(frontO, backO);
        int matchedX = Math.min(frontX, backX);

        System.out.println(matchedO + matchedX);
    }
}