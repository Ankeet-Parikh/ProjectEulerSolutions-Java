

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem359 {
	/*The initial main was to show where the first 100 integers were in the hotel. 
	 * From that, I was able to determine the pattern in which the numbers showed up:
	 * 
	 * The first numbers on each floor are 
	 * 1,2,4,8,12,18,24,32,40
	 * Which is floor(n^2/2) for n>2. 
	 * Since we define the difference between numbers, we need a place to start
	 * 
	 * 
	 * The first row are the triangular numbers. Each room r, r>=1, contains the 
	 * number r*(r+1)/2.
	 * 
	 * Each subsequent row shows a pattern:
	 * On each odd floor f,the difference between numbers is:
	 * 1, 2f, 3, 2f+2, 5, 2f+4, 7, 2f+6, 9, 2f+8, 11, 2f+10, 13
	 * 
	 * On each even floor f, the difference between numbers is:
	 * 2f+1, 2, 2f+3, 4, 2f+5, 6, 2f+7, 8, 2f+9, 10, 2f+11, 12, 2f+13, 14
	 * 
	 * We can see that each row has sums of consecutive odd sequences and consecutive even sequences.
	 * For each floor, we need to know how many terms are in the even sequence and how many are in the
	 * odd in order to determine what the value at room r is. Also, we need to know at which number both
	 * the sequences begin.
	 *  We can sum the sequences up with summation formulas described on wikipedia.
	 * 
	*/
	public static void main(String[] args)
	{
		
		long n = 71328803586048L;
		ArrayList<Long> f = Divisors(n);
		
		BigInteger s = new BigInteger("0");
		BigInteger m = new BigInteger("100000000");
		for(int i=0;i<f.size(); i++)
		{
			s = s.add(P(f.get(i), n/f.get(i)));
		}
		
		System.out.println(s.mod(m));
		
		
	}
	
	public static BigInteger P(long a, long b)//error in precision with double
	{
		BigInteger f = new BigInteger("" +a);
		BigInteger r = new BigInteger("" +b);
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		
		if(f.compareTo(new BigInteger("1")) == 0) return r.multiply(r.add(one)).divide(two);
		else
		{
			BigInteger init = f.multiply(f).divide(two);//first number on floor
			if(r.compareTo(one) ==0) return init;
			BigInteger ts = r.subtract(one); //terms in difference sequence
			BigInteger ie = f.mod(two).compareTo(zero) ==0?   two :   f.multiply(two);
			BigInteger io = f.mod(two).compareTo(zero) ==0?   f.multiply(two).add(one)  :     one;
			BigInteger tie = ts.mod(two).compareTo(zero)==0? ts.divide(two): ts.divide(two);//terms in even sequence
			BigInteger tio = ts.mod(two).compareTo(zero)==0? ts.divide(two): ts.divide(two).add(one);//terms in odd sequence
			BigInteger count = init;
			
			if(!(tio.compareTo(zero) == 0) )
			{
				BigInteger l = (io.subtract(one)).divide(two);
				BigInteger u = tio.add(l).subtract(one);
				//count+=2*(u*(u+1)/2 - l*(l-1)/2) +u+1-l;
				//inner = (u*(u+1)/2 - l*(l-1)/2)
				BigInteger inner =(u.multiply(u.add(one)).divide(two)).subtract(l.multiply(l.subtract(one)).divide(two)) ;
				count = count.add(two.multiply(inner).add(u).subtract(l).add(one));
			}
			if(!(tie.compareTo(zero) == 0))
			{
				BigInteger l = ie.divide(two) ;
				BigInteger u = tie.add(l).subtract(one);
				//count+= 2*(u*(u+1)/2 - l*(l-1)/2);
				//inner = (u*(u+1)/2 - l*(l-1)/2)
				BigInteger inner =(u.multiply(u.add(one)).divide(two)).subtract(l.multiply(l.subtract(one)).divide(two)) ;
				count = count.add(two.multiply(inner));
			}
			return count;
				
			
		}
		
	}
	


	
	public static ArrayList<Long> Divisors(long n)
	{
		ArrayList<Long> f = new ArrayList<Long>(0);
		for(long i =1; i<=Math.sqrt(n); i++)
		{
			if(n%i==0)
			{
				f.add(i);
				f.add(n/i);
			}
		}
		return f;
	}
	
}
/*
public static double P(double f, double r)//double to handle large values
	{
		
		if(f == 1) return r*(r+1)/2;
		else
		{
			double init = Math.floor(f*f/2);//first number on floor
			if(r == 1) return init;
			double ts = r-1; //terms in difference sequence
			double ie = f%2==0?   2      :   2*f;
			double io = f%2==0?   2*f+1  :     1;
			double tie = ts%2==0? ts/2: Math.floor(ts/2);//terms in even sequence
			double tio = ts%2==0? ts/2: Math.floor(ts/2)+1;//terms in odd sequence
			double count = init;
			
			if(tio != 0 )
			{
				double l = (io-1)/2;
				double u = tio +l-1;
				count+=2*(u*(u+1)/2 - l*(l-1)/2) +u+1-l;
			}
			if(tie !=0)
			{
				double l = ie/2 ;
				double u = tie+l-1;
				count+= 2*(u*(u+1)/2 - l*(l-1)/2);
			}
			return count;
				
			
		}
		
	}
 */
/*
public static void main(String[] args)
{
	System.out.println(FactorInteger(71328803586048L).size());
	int x=300, r=20000;
	int[][] h = new int[x][1];
	h[0][0] =1;
	int max =0;
	for(int i=2; i<=r; i++)
	{
		
		for(int f=0; f<h.length; f++)
		{
			long last = h[f][h[f].length-1];
			if(last==0) 
			{
				h[f][0] = i;
				break;
			}
			else
			{
				double rt = Math.sqrt(last+i);
				if(rt == (int)rt)
				{
					h[f] =appendTo(h[f], i);
					break;
				}
			}
				
		}
		
	}
	System.out.println(h[98][99]);
}
public static void Print1D(int a[])
{
	for(int i =0; i<a.length; i++)
		System.out.print(a[i] +" ");
	System.out.println("");
	
}
public static void Print2D(int a[][])
{
	for(int i=0; i<a.length; i++)
	{
		Print1D(a[i]);
	}
}
	public static int[] appendTo(int[] a, int b)//put b as the last element in a
{
	int[] n = new int[a.length+1];
	for(int i=0; i<n.length; i++)
	{
		n[i] = i != n.length-1?a[i]:b;
	}
	return n;
}
*/