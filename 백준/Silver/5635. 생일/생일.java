import java.io.*;
import java.util.*;

public class Main {

    static class Student {
        String name;
        int d, m, y;

        Student(String name, int d, int m, int y) {
            this.name = name;
            this.d = d;
            this.m = m;
            this.y = y;
        }

        boolean youngerThan(Student other) {
            if (this.y != other.y) return this.y > other.y;
            if (this.m != other.m) return this.m > other.m;
            return this.d > other.d;
        }

        boolean olderThan(Student other) {
            if (this.y != other.y) return this.y < other.y;
            if (this.m != other.m) return this.m < other.m;
            return this.d < other.d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Student youngest = null;
        Student oldest = null;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Student cur = new Student(name, d, m, y);

            if (youngest == null || cur.youngerThan(youngest)) {
                youngest = cur;
            }
            if (oldest == null || cur.olderThan(oldest)) {
                oldest = cur;
            }
        }

        System.out.println(youngest.name);
        System.out.println(oldest.name);
    }
}
