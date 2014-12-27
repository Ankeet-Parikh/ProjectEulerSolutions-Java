package problems_20_29;
import java.io.*;

import java.util.*;

public class Problem22 {

	
	public static void main(String[] args) throws IOException {
		//System.out.println(nameScore("COLIN"));
		ArrayList<String> names = new ArrayList<String>();
		
	
		Scanner scan =  new Scanner(new File("names.txt"));
		String list = scan.nextLine();
			
		String current ="";
		
		for(int i = 0;i< list.length();i++)
		{
			if(list.substring(i,i+1).charAt(0) >= 65 && list.substring(i,i+1).charAt(0) <= 90)
				current+= list.substring(i,i+1);
			
			if(list.substring(i,i+1).equals(",") || i == list.length()-1)
			{
				names.add(current);
				
				current ="";
			}
				
		}
		//System.out.println(names);
		Alphabetize(names);
		//System.out.println(names);
		int sumNameScores =0;
		for(int i =0;i < names.size(); i++)
		{
			sumNameScores+=(i+1)*nameScore(names.get(i));
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
	
	public static void Alphabetize(ArrayList<String> names)
	{
		for(int i = 0; i< names.size()-1; i++)
		{
			for(int j =0 ; j<names.size() -1 ; j++)
			{
				if(swapNames(names.get(j),names.get(j+1)))
				{
					String s = new String(names.get(j));
					names.set(j, names.get(j+1));
					names.set(j+1, s);
				}
			}
		}
	}
	public static boolean swapNames(String first, String second)
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

