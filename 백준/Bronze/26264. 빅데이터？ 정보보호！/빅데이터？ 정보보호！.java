import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int bigdataCount = 0;
        int securityCount = 0;

        int index = 0;
        while (index < input.length()) {
            if (input.startsWith("bigdata", index)) {
                bigdataCount++;
                index += 7;
            } else if (input.startsWith("security", index)) {
                securityCount++;
                index += 8;
            } else {
                break;
            }
        }

        if (bigdataCount > securityCount) {
            System.out.println("bigdata?");
        } else if (bigdataCount < securityCount) {
            System.out.println("security!");
        } else {
            System.out.println("bigdata? security!");
        }
    }
}