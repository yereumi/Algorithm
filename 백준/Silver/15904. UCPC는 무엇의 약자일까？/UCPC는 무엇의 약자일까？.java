import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String target = "UCPC";
        int idx = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == target.charAt(idx)) {
                idx++;
                if (idx == 4) break;
            }
        }

        if (idx == 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }

        sc.close();
    }
}