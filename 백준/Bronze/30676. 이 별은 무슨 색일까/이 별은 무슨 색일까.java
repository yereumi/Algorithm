import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lambda = Integer.parseInt(br.readLine());
        
        if (lambda >= 620) System.out.println("Red");
        else if (lambda >= 590) System.out.println("Orange");
        else if (lambda >= 570) System.out.println("Yellow");
        else if (lambda >= 495) System.out.println("Green");
        else if (lambda >= 450) System.out.println("Blue");
        else if (lambda >= 425) System.out.println("Indigo");
        else System.out.println("Violet");
    }
}