package problems_60_69;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem66 {
	public static void main(String[] args)
	{
		
	
		long max =0;
		BigInteger maxX=new BigInteger("0");
		for(int i =2; i<=1000; i++)
		{
			BigInteger minX = minXPell(i);
			if(minX.compareTo(maxX)>0)
			{
				maxX = minX;
				max =i;
			}
		}
		System.out.println(max);
		
		
	}
	
	public static boolean solvesIt(BigInteger x, BigInteger y, long D)
	{
		return x.multiply(x).subtract(y.multiply(y).multiply(new BigInteger(""+D))).equals(new BigInteger("1"));
	}
	
	public static BigInteger minXPell(long n)
	{
		double sqrt = Math.sqrt(n);
		if(sqrt == (int)sqrt) return new BigInteger("0");
		ArrayList<Long> rep = repeatingBlock(n);
		BigInteger Amin1=new BigInteger("" + (long)Math.floor(sqrt));
		BigInteger A= Amin1.multiply(new BigInteger(""+rep.get(0))).add(new BigInteger("1"));
		BigInteger Bmin1= new BigInteger("1");
		BigInteger B=new BigInteger("" +rep.get(0));
		int i=0;
		while(true)
		{
			if(solvesIt(A,B,n)) break;
			i++;
			i%=rep.size();
			BigInteger tempA = new BigInteger(A.toString());
			BigInteger tempB = new BigInteger(B.toString());
			A=A.multiply(new BigInteger(""+rep.get(i))).add(Amin1);
			B=B.multiply(new BigInteger(""+rep.get(i))).add(Bmin1);;
			Amin1 =tempA ;
			Bmin1= tempB;
		}
		return A;
	}
	/*
	public static long minXPell(long n)
	{
		double sqrt = Math.sqrt(n);
		if(sqrt == (int)sqrt) return 0;
		ArrayList<Long> rep = repeatingBlock(n);
		long Amin1 = (long)Math.floor(sqrt);//this declares it as A_0
		long A =rep.get(0)*Amin1+1;
		long Bmin1 =1;
		long B =rep.get(0);
		int i = 0;
		while(true)
		{
			if(solvesIt(A,B, n))
				break;
			i++;
			i%=rep.size();
			long tempA =A;
			long tempB =B;
			A = rep.get(i)*A+Amin1;
			B = rep.get(i)*B+Bmin1;
			Amin1 = tempA;
			Bmin1 = tempB;
			
		}
		return A;
		
	}
	*/
	public static ArrayList<Long> repeatingBlock(long n) 
	{
		//returns the list of the a_0 of the continued fraction of n
		ArrayList<Long> list = new ArrayList<Long>(0);
		long m =0;
		long d =1;
		long a_0 = (long)Math.floor(Math.sqrt(n));
		long a = a_0;
		
		while(a != 2*a_0)
		{	
			m=d*a-m;
			d = (n-m*m)/d;
			a= (a_0+m)/d;
			list.add(a);
		}
		
		return list;
	}
	
	
}
