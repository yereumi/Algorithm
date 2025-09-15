import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int happy = 0, sad = 0;
        for (int i = 0; i + 2 < s.length(); i++) {
            String sub = s.substring(i, i + 3);
            if (sub.equals(":-)")) happy++;
            else if (sub.equals(":-(")) sad++;
        }

        if (happy == 0 && sad == 0) {
            System.out.println("none");
        } else if (happy == sad) {
            System.out.println("unsure");
        } else if (happy > sad) {
            System.out.println("happy");
        } else {
            System.out.println("sad");
        }
    }
}