import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 세미나 -> 교실 매핑
        Map<String, String> seminarRoomMap = Map.of(
            "Algorithm", "204",
            "DataAnalysis", "207",
            "ArtificialIntelligence", "302",
            "CyberSecurity", "B101",
            "Network", "303",
            "Startup", "501",
            "TestStrategy", "105"
        );

        int n = Integer.parseInt(sc.nextLine()); // 세미나 수
        for (int i = 0; i < n; i++) {
            String seminar = sc.nextLine();
            System.out.println(seminarRoomMap.get(seminar));
        }
    }
}