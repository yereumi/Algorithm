import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            String[] syllables = line.split("\\s+"); 

            StringBuilder result = new StringBuilder("god");

            for (int j = 1; j < syllables.length; j++) {
                result.append(syllables[j]);
            }

            System.out.println(result);
        }
    }
}