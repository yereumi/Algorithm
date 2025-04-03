import java.util.*;
import java.util.Map.Entry;

class Solution {
    
    static Map<String, List<String>> graph;
    static List<String> answer;
    
    static void dfs(String airport) {
        List<String> destinations = graph.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.remove(0);
            dfs(nextAirport);
        }
        answer.add(airport);
    }
    
    public static List<String> solution(String[][] tickets) {
        graph = new HashMap<>();
        for (String[] t : tickets) {
            graph.putIfAbsent(t[0], new ArrayList<>());
            graph.get(t[0]).add(t[1]);
        }
        for (Entry<String, List<String>> entry : graph.entrySet()) {
            Collections.sort(entry.getValue());
        }
        answer = new ArrayList<>();
        dfs("ICN");
        Collections.reverse(answer);
        return answer;
    }
}