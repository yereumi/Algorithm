import java.io.*;
import java.util.*;

public class Main {
    static final int DAYS = 366;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] tab = new int[DAYS + 2];
        int[] space = new int[DAYS + 2];
        int longest = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (c == 'T') {
                tab[s] += 1;
                tab[e + 1] -= 1;
            } else {
                space[s] += 1;
                space[e + 1] -= 1;
            }

            longest = Math.max(longest, e - s + 1); // 최장 투숙
        }

        for (int i = 1; i <= DAYS; i++) {
            tab[i] += tab[i - 1];
            space[i] += space[i - 1];
        }

        int occupiedDays = 0;
        int maxGuests = 0;
        int peacefulDays = 0;
        int maxPeaceGuests = 0;

        for (int i = 1; i <= DAYS; i++) {
            int t = tab[i];
            int s = space[i];
            int total = t + s;

            if (total > 0) {
                occupiedDays++;
                maxGuests = Math.max(maxGuests, total);
            }

            boolean peaceful = false;
            if (t == 0 || s == 0) {
                peaceful = false; // 관리자 싸움
            } else if (t == s) {
                peaceful = true; // 균형
            }

            if (peaceful) {
                peacefulDays++;
                maxPeaceGuests = Math.max(maxPeaceGuests, total);
            }
        }

        System.out.println(occupiedDays);
        System.out.println(maxGuests);
        System.out.println(peacefulDays);
        System.out.println(maxPeaceGuests);
        System.out.println(longest);
    }
}