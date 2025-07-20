import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int flour = sc.nextInt();
        int chocolate = sc.nextInt();
        int egg = sc.nextInt();
        int butter = sc.nextInt();

        int flourNeed = sc.nextInt();
        int chocolateNeed = sc.nextInt();
        int eggNeed = sc.nextInt();
        int butterNeed = sc.nextInt();

        int Q = sc.nextInt();
        int cookieCount = 0;

        for (int i = 0; i < Q; i++) {
            int type = sc.nextInt();
            int val = sc.nextInt();

            switch (type) {
                case 1:
                    if (flour >= flourNeed * val &&
                        chocolate >= chocolateNeed * val &&
                        egg >= eggNeed * val &&
                        butter >= butterNeed * val) {

                        flour -= flourNeed * val;
                        chocolate -= chocolateNeed * val;
                        egg -= eggNeed * val;
                        butter -= butterNeed * val;
                        cookieCount += val;
                        System.out.println(cookieCount);
                    } else {
                        System.out.println("Hello, siumii");
                    }
                    break;
                case 2:
                    flour += val;
                    System.out.println(flour);
                    break;
                case 3:
                    chocolate += val;
                    System.out.println(chocolate);
                    break;
                case 4:
                    egg += val;
                    System.out.println(egg);
                    break;
                case 5:
                    butter += val;
                    System.out.println(butter);
                    break;
            }
        }
    }
}