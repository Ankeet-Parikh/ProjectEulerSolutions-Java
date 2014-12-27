

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem99 {

	
	public static void main(String[] args) throws FileNotFoundException 
	{
		ArrayList<String> lines = new ArrayList<String>();
		Scanner scan = new Scanner(new File("src/base_exp.txt"));
		while(scan.hasNext()) 
		{
			lines.add(scan.nextLine());
		}
		double maxLineValue =0;
		int maxLine =0;
		for(int i =0; i< lines.size(); i++)
		{
			double size = expSize(Double.parseDouble(lines.get(i).split(",")[0]), Double.parseDouble(lines.get(i).split(",")[1]));
			if(size> maxLineValue)
			{
				maxLine = i+1;
				maxLineValue =size;
			}
		}
		
		System.out.println(maxLine);
	}
	
	public static double expSize(double base, double exp)
	{
		return exp*Math.log10(base);
	}
	
}

