package src;

import java.math.BigInteger;

public class Problem482 {
	public static void main(String args[])
	{
		double sum = 0;
		for(int i =0; i<=10000000; i++)
		{
			sum+=numTriangles(i);
		}
		System.out.println((long)sum);
	}
	
	public static double numTriangles(double n )
	{
		return (long)(Math.round(n*n/12) - Math.floor(n/4)*Math.floor((n+2)/4));
	}
}
