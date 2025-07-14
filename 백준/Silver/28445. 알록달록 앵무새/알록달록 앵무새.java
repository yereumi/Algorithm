import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String dadBody = sc.next();
        String dadTail = sc.next();
        String momBody = sc.next();
        String momTail = sc.next();

        Set<String> colorSet = new HashSet<>();
        colorSet.add(dadBody);
        colorSet.add(dadTail);
        colorSet.add(momBody);
        colorSet.add(momTail);

        List<String> colors = new ArrayList<>(colorSet);
        Collections.sort(colors);

        Set<String> resultSet = new TreeSet<>();

        for (String body : colors) {
            for (String tail : colors) {
                resultSet.add(body + " " + tail);
            }
        }

        for (String pair : resultSet) {
            System.out.println(pair);
        }
    }
}