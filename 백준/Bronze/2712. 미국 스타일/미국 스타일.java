import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < T; i++) {
            double value = sc.nextDouble();
            String unit = sc.next();

            double convertedValue = 0.0;
            String convertedUnit = "";

            switch (unit) {
                case "kg":
                    convertedValue = value * 2.2046;
                    convertedUnit = "lb";
                    break;
                case "lb":
                    convertedValue = value * 0.4536;
                    convertedUnit = "kg";
                    break;
                case "l":
                    convertedValue = value * 0.2642;
                    convertedUnit = "g";
                    break;
                case "g":
                    convertedValue = value * 3.7854;
                    convertedUnit = "l";
                    break;
            }

            System.out.printf("%.4f %s\n", convertedValue, convertedUnit);
        }

        sc.close();
    }
}