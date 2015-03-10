import java.io.*;
import java.util.*;


public class Problem105 {
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("src/sets.txt"));
		int[] x ={1,2,3,4};
		System.out.println(sum(x));
	}
	
	public static long SumIfSpecial(int[] set)
	{
		
		return 0;
	}
	
	public static long sum(int[] n)
	{
		long s =0;
		for(int i: n) s+=i;
		return s;
	}
}
