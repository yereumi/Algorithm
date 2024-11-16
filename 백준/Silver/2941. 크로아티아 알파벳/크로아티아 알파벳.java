import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		line = line.replaceAll("c=", "k");
		line = line.replaceAll("c-", "k");
		line = line.replaceAll("dz=", "k");
		line = line.replaceAll("d-", "k");
		line = line.replaceAll("lj", "k");
		line = line.replaceAll("nj", "k");
		line = line.replaceAll("s=", "k");
		line = line.replaceAll("z=", "k");
//		System.out.println(line);
		System.out.println(line.length());
	}
}
