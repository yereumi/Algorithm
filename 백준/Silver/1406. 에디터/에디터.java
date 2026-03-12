import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String str = br.readLine();

        for (char c : str.toCharArray()) {
            left.push(c);
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.equals("L")) {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if (command.equals("D")) {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if (command.equals("B")) {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else if (command.startsWith("P")) {
                char x = command.charAt(2);
                left.push(x);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}
