package problems_200_209;

import java.math.BigInteger;
import java.util.*;

public class Problem203 {
	public static void main(String args[] )
	{
		ArrayList<Long> list = new ArrayList<Long>(0);
		long line[]  ={1};
		for(int i =0; i<51; i++)
		{
			for(int j =0; j<line.length; j++)
			{
				list.add(line[j]);
			}
			line = nextLine(line);
		}
		
		
		Collections.sort(list);
		removeDups(list); //remove duplicates
		
		BigInteger count = new BigInteger("0");
		
		for(int i =0; i<list.size(); i++)
		{
			if(isSquareFree(list.get(i)))
			{
				count = count.add(new BigInteger(""+list.get(i)));
				
			}
		}
		
		System.out.println(count);
		
	}
	
	public static void removeDups(ArrayList<Long> arr)
	{
		
		for(int i=0; i<arr.size();i++ )
		{
			long curr = arr.get(i);
			int j =i+1;
			while(j < arr.size() && curr == arr.get(j))
			{
				arr.remove(j);
				
			}
		}
	}
	public static long[] nextLine(long[] n)
	{
		long[] next = new long[n.length+1];
		for(int i =0; i<next.length; i++)
		{
			if(i ==0 || i==next.length-1)
			{
				next[i] =1;
			}
			else
				next[i] = n[i-1]+n[i];
		}
		return next;
	}

	public static boolean isSquareFree(long n)
	{
		for(long i =2; i<=n; i++)
		{
			int count =0;
			while(n%i==0)
			{
				n/=i;
				count++;
				if(count == 2) return false;
			}
		}
		return true;
	}
	
	
}
