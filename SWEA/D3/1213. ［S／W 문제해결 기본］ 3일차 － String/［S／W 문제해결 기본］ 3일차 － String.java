import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			String num = br.readLine();
			String find = br.readLine();
			String str = br.readLine();
			System.out.println("#" + num + " " + (str.split(find, -1).length - 1));
        }
	}
}