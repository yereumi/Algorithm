import java.io.*;

public class Main {

    static int sum(String expr) {
        int s = 0;
        String[] parts = expr.split("\\+");
        for (String p : parts) {
            s += Integer.parseInt(p);
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] minusSplit = input.split("-");

        int result = sum(minusSplit[0]);

        for (int i = 1; i < minusSplit.length; i++) {
            result -= sum(minusSplit[i]);
        }

        System.out.println(result);
    }
}
