

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem99 {

	
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		Scanner scan = new Scanner(new File("src/base_exp.txt"));
		int maxline  =0;
		double maxval =0;
		int i=1;
		while(scan.hasNext()) 
		{
			String[] line = scan.nextLine().split(",");
			double a = Double.parseDouble(line[0]);
			double b = Double.parseDouble(line[1]);
			double bloga = b*Math.log(a);
			if(bloga > maxval) 
			{
				maxline =i;
				maxval = bloga;
			}
			i++;
		}
		
		
		System.out.println(maxline);
	}
	
	
}

