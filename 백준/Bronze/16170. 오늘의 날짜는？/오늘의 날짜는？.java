import java.util.*;
import java.io.*;
import java.math.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        LocalDate now = LocalDate.now();
        System.out.println(now.getYear());
        System.out.printf("%02d\n", now.getMonthValue());
        System.out.printf("%02d\n", now.getDayOfMonth());
    }
}