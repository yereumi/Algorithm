import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int birthY = sc.nextInt();
        int birthM = sc.nextInt();
        int birthD = sc.nextInt();

        int currentY = sc.nextInt();
        int currentM = sc.nextInt();
        int currentD = sc.nextInt();

        // 만 나이
        int age = currentY - birthY;
        if (currentM < birthM || (currentM == birthM && currentD < birthD)) {
            age--;
        }

        // 세는 나이
        int countingAge = currentY - birthY + 1;

        // 연 나이
        int yearAge = currentY - birthY;

        System.out.println(age);
        System.out.println(countingAge);
        System.out.println(yearAge);
    }
}