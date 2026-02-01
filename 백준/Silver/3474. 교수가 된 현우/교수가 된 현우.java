import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());
            long count = 0;

            for (long div = 5; div <= N; div *= 5) {
                count += N / div;
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb.toString());
    }
}
