import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int totalPorts = 0;

        for (int i = 0; i < n; i++) {
            int ports = Integer.parseInt(br.readLine());
            totalPorts += ports;
        }

        int maxComputers = totalPorts - (n - 1);
        System.out.println(maxComputers);
    }
}