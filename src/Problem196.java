import java.math.BigInteger;
import java.util.ArrayList;
public class Problem196 {
	static int[] p = {2,3,5,7,11,13,17,19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
	public static void main(String[] args)
	{
		double s = System.currentTimeMillis();
		//System.out.println(S(8));
		//System.out.println(S(9));
		//System.out.println(S(10000));
		int a = 5678027, b = 7208785;
		long s1 = 0, s2 = 0;
		//System.out.println(s1=S(a));
		//System.out.println(s2=S(b));
		System.out.println(S(a)+S(b));
		System.out.println((System.currentTimeMillis()-s)/1000 + " seconds");
	}
	
	public static long S(long n)
	{
		/*
		 * Consider 5 rows:
		 * ex:
		 * 1
		 * 2 3
		 * 4 5 6
		 * 7 8 9 10
		 * 11 12 13 14 15
		 * 
		 */
		n-=1; //counting here starts at zero
		//Part 1: Prime generation
		boolean[][] p = new boolean[5][(int)(n+2)];
		for(int i=0; i<p.length; i++)
		{
			long l = n - (2 - i);
			long init = l * (l+1)/2 +1;
			for(int j = 0; j<p[0].length-(4-i); j++, init++)
			{
				//System.out.println(init);
				p[i][j] = isPrime(init);
			}
		}
		//Part 2, triple finding
		long s = 0;
		for(int i =0; i <p[2].length; i++)
		{
			if(p[2][i])//if the current number is prime, 
			{
				int[][] nb = getNeighbors((int)(n+2), 2,i);//neighbors
				int pn = 0; //count the number of prime neighbors
				for(int j =0; j<nb.length; j++) if(p[nb[j][0]][nb[j][1]]) pn++;
				if(pn >= 2)
				{
					s+= n*(n+1)/2+1+i;
					continue;
				}
				else
				{
					for(int j =0; j<nb.length; j++)
					{
						if(p[nb[j][0]][nb[j][1]])//element is prime
						{
							int[][] nnb = getNeighbors((int)n+2,nb[j][0],nb[j][1]);
							int pnn = 0;
							for(int k =0; k<nnb.length; k++) if(p[nnb[k][0]][nnb[k][1]]) pnn++;
							if(pnn >=2)
							{
								s+= n* (n+1)/2+1+i;
								break;
							}
						}
					}
				}
			}
		}
		return s;	
	}
	
	public static int[][] getNeighbors(int n, int i, int j)
	{
		//neighbors of rect[i][j] where rect is 5 by n array
		
		//all neigbors, including invalid ones, clockwise
		int[][] anb = {{i-1,j-1},{i-1, j},{i-1,j+1},{i, j-1},{i, j+1},{i+1, j-1},{i+1, j},{i+1, j+1}};
		ArrayList<Integer[]> b = new ArrayList<Integer[]>(0);
		for(int e=0; e<anb.length; e++)
		{
			
			if(anb[e][0] < 0 || anb[e][0] >= 5 || anb[e][1] < 0 || anb[e][1] >= n )
			{
				continue;
			}
			else
			{
				b.add(new Integer[]{anb[e][0],anb[e][1]});
			}
		}
		int[][] nb = new int[b.size()][2];
		for(int e =0; e<nb.length; e++)
		{
			nb[e][0] =b.get(e)[0];
			nb[e][1] =b.get(e)[1];
		}
		return nb;
	}
	public static boolean isPrime(long n)
	{
		
		for(int i=0; i<p.length; i++)
		{
			if(n%p[i]==0) return false;
		}
		return new BigInteger(""+n).isProbablePrime(2);
	}
	public static void Print1d(int[] a)
	{
		System.out.print("{");
		for(int i =0; i<a.length; i++)
		{
			System.out.print(a[i]);
			if(i <a.length-1) System.out.print(", ");
		}
		System.out.print("}");
	}
	
	public static void Print2d(int[][] a)
	{
		System.out.print("{");
		for(int i=0; i<a.length; i++)
		{
			Print1d(a[i]);
			if(i<a.length-1) System.out.print(",");
		}
		System.out.println("}");
	}
}
