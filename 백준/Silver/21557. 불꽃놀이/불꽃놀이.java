import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) - 2;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        while (n-- > 1) {
            if (a > b) a--;
            else b--;
        }

        System.out.println(Math.max(a, b) - 1);
    }
}
