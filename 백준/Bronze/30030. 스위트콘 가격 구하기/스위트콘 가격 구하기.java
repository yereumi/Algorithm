import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int B = Integer.parseInt(br.readLine());
        int A = B * 10 / 11;
        System.out.println(A);
    }
}