package problems_240_249;

import java.util.ArrayList;

public class Problem243 {
	
	public static void main(String [] args)
	{
		System.out.println(primeSieve(15));
	}
	
	public static ArrayList<Integer> primeSieve(int n) //get first n primes
	{
		//trial division is fast enough, because not many primes are to be created
		ArrayList<Integer> p = new ArrayList<Integer>(0);
		for(int i=2; ; i++)
		{
			//trial division
			p.add(i);
			for(int j =2; j<= Math.sqrt(i); j++)
			{
				if(i%j==0)
				{
					p.remove(p.size()-1);
					break;
				}
			}
			if(p.size() == n )
				break;
		}
		return p;
	}
	
	

}
