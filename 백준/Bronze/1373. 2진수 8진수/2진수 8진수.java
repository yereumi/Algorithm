import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.nextLine();

        int padding = (3 - binary.length() % 3) % 3;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padding; i++) sb.append("0");
        sb.append(binary);
        binary = sb.toString();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 3) {
            String group = binary.substring(i, i + 3);
            int octal = Integer.parseInt(group, 2);
            result.append(octal);
        }

        System.out.println(result);
    }
}