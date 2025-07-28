import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String hex = sc.next();
        int N = sc.nextInt();
        String[] types = new String[N];

        for (int i = 0; i < N; i++) {
            types[i] = sc.next();
        }

        int idx = 0;
        for (int i = 0; i < N; i++) {
            int len = getHexLength(types[i]);

            String part = hex.substring(idx, idx + len);
            long value = Long.parseUnsignedLong(part, 16);
            System.out.print(value + " ");

            idx += len;
        }
    }

    private static int getHexLength(String type) {
        switch (type) {
            case "char": return 2;        // 1 byte = 2 hex chars
            case "int": return 8;         // 4 byte = 8 hex chars
            case "long_long": return 16;  // 8 byte = 16 hex chars
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}