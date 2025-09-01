import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int low = 1, high = 10;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            int guess = Integer.parseInt(line);
            if (guess == 0) break;

            String response = br.readLine().trim();

            if (response.equals("too high")) {
                high = Math.min(high, guess - 1);
            } else if (response.equals("too low")) {
                low = Math.max(low, guess + 1);
            } else if (response.equals("right on")) {
                if (guess >= low && guess <= high) {
                    System.out.println("Stan may be honest");
                } else {
                    System.out.println("Stan is dishonest");
                }
                low = 1; high = 10;
            }
        }
    }
}