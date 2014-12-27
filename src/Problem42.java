

import java.io.*;
import java.util.*;

public class Problem42 {

	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("src/Problem42Words.txt"));
		ArrayList<String>  words = new ArrayList<String>();
		String wordList = scan.nextLine(); 
		String current = "";
		for(int i =0 ; i< wordList.length()-1; i++)
		{
			if(wordList.substring(i,i+1).charAt(0) >= 65 && wordList.substring(i,i+1).charAt(0) <= 90)
				current+= wordList.substring(i,i+1);
			if(wordList.substring(i, i+1).equals(","))
			{
				words.add(current);
				
				current ="";
			}
			
		}
		
		int numTriangleWords=0;
		for(int i =0 ; i< words.size(); i++)
		{
			if(isTriangle(wordScore(words.get(i))))
				numTriangleWords++;
		}
		System.out.println(numTriangleWords);
		
		
	}
	public static int wordScore(String s)
	{
		int score =0;
		for(int i =0; i< s.length(); i++)
		{
			score+= s.charAt(i) - 64; 
		}
		return score;
	}
	public static boolean isTriangle(int num)
	{
		return (-0.5 + Math.pow(0.5*0.5+2*num,0.5))%1==0;
	}

}
