import java.util.*;
import java.io.*;

public class Main {
	
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int ball = 1;
        for (int i = 0; i < n; i++) {
        	int c1 = read();
        	int c2 = read();
        	if (c1 == ball) {
        		ball = c2;
        	} else if (c2 == ball) {
        		ball = c1;
        	}
        }
        System.out.println(ball);
    }
}