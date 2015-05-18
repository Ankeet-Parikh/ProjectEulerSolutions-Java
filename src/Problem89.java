import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem89 {
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("src/p089_roman.txt"));
		int sum =0;
		while(scan.hasNext())
		{
			String c = scan.nextLine();
			int l = c.length();
			c = makeShorter(c);
			sum+=(l-c.length());
		}
		System.out.println(sum);
	}
	public static String makeShorter(String r)
	{
		if(r.contains("IIIII")) r = r.replaceAll("IIIII", "V");
		if(r.contains("IIII")) r = r.replaceAll("IIII", "IV");
		if(r.contains("VIV")) r = r.replaceAll("VIV", "IX");
		if(r.contains("VV")) r = r.replaceAll("VV", "X");
		if(r.contains("XXXX")) r = r.replaceAll("XXXX", "XL");
		if(r.contains("XXXXX")) r = r.replaceAll("XXXXX", "L");
		if(r.contains("LXL")) r = r.replaceAll("LXL", "XC");
		if(r.contains("LL")) r = r.replaceAll("LL", "C");
		if(r.contains("CCCC")) r = r.replaceAll("CCCC", "CD");
		if(r.contains("DCD")) r = r.replaceAll("DCD", "CM"); 
		if(r.contains("DD")) r = r.replaceAll("DD","M" );
		return r;
	}
}
