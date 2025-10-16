import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String A = input[0];
        String B = input[1];
        
        int i = A.length() - 1;
        int j = B.length() - 1;
        StringBuilder sb = new StringBuilder();
        
        while (i >= 0 || j >= 0) {
            int x = (i >= 0) ? A.charAt(i) - '0' : 0;
            int y = (j >= 0) ? B.charAt(j) - '0' : 0;
            sb.insert(0, x + y);
            i--;
            j--;
        }
        
        System.out.println(sb.toString());
    }
}