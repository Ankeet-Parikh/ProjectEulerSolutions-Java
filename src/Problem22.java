
import java.io.*;
import java.util.*;

public class Problem22 {

	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan =  new Scanner(new File("src/names.txt"));
		String list = scan.nextLine();
		list = list.replaceAll("\"", ""); //remove all quotation marks
		String[] names = list.split(",");     //split them by commas
	
		Alphabetize(names);
		
		int sumNameScores =0;
		for(int i =0;i < names.length; i++)
		{
			sumNameScores+=(i+1)*nameScore(names[i]);
		}
		System.out.println(sumNameScores);

	}
	public static int nameScore(String s)
	{
		int sum =0;
		for(int i = 0; i< s.length(); i++)
		{
			sum+=s.substring(i,i+1).charAt(0)-64;
		}
		return sum;
	}
	
	public static void Alphabetize(String[] names)
	{
		for(int i = 0; i< names.length-1; i++)
		{
			for(int j =0 ; j<names.length -1 ; j++)
			{
				if(compNames(names[j],names[j+1]))
				{
					String s = new String(names[j]);
					names[j] = names[j+1];
					names[j+1] =s;
				}
			}
		}
	}
	public static boolean compNames(String first, String second)
	{
		int smaller =0;
		if(first.length() > second.length()) smaller = second.length();
		else smaller = first.length();
		
		for(int i = 0; i < smaller; i++)
		{
			if(first.charAt(i) > second.charAt(i))
				return true;
			if(first.charAt(i) < second.charAt(i))
				return false;
		}
		if(second.length() > first.length()) return false;
		else return true;
	}

}


