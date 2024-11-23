import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double answer = 0.0;
		double sum = 0.0;
		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			double unit = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			if (!grade.equals("P")) {
				sum += unit;
				answer += calculateScore(unit, grade);
			}
		}
		System.out.println(String.format("%.6f", answer / sum));
	}
	
	public static double calculateScore(double unit, String grade) {
		if (grade.equals("A+")) {
			return unit * 4.5;
		} else if (grade.equals("A0")) {
			return unit * 4.0;
		} else if (grade.equals("B+")) {
			return unit * 3.5;
		} else if (grade.equals("B0")) {
			return unit * 3.0;
		} else if (grade.equals("C+")) {
			return unit * 2.5;
		} else if (grade.equals("C0")) {
			return unit * 2.0;
		} else if (grade.equals("D+")) {
			return unit * 1.5;
		} else if (grade.equals("D0")) {
			return unit * 1.0;
		}
		return unit * 0.0;
	}
}
