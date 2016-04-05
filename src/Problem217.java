
public class Problem217 {
	public static void main(String[] args)
	{
		System.out.println(Tbrute(5));
		T(5);

	}
	public static long T(int n)
	{
		if(n == 1) return 45;
		long mod = 1;
		for(int i=0; i<15; i++) mod*=3;
		long[][] A = new long[9*(n/2)+1][n/2+1]; //A[i][j] = sum of all integers of length j with digits that sum to i (no leading zeros)
		long[][] B = new long[9*(n/2)+1][n/2+1]; //B[i][j] = sum of all integers of length j with digits that sum to i (leading zeros allowed)
		long[][] Na = new long[A.length][A[0].length]; //Na[i][j] = # of ints that satisfy A[i][j]
		long[][] Nb = new long[B.length][B[0].length]; //Nb[i][j] = # of ints that satisfy B[i][j]
		

		
		
		for(int j = 1; j<Nb[0].length; j++)
		{
			Na[0][j] = 1;
			Nb[0][j] = 1;
		}
		for(int i =0; i<= 9; i++)
		{
			Na[i][1] = 1;
			Nb[i][1] = 1;
		}
		for(int i=1; i<=9; i++)
		{
			B[i][1] = i;
			A[i][1] = i;
		}
		for(int j = 1; j<Nb[0].length; j++)
		{
			for(int i=1; i<Nb.length; i++)
			{
				for(int k = i-9 > 0? i-9: 0; k<=i ;k++)
				{
					Nb[i][j] += Nb[k][j-1];
					//Nb[i][j] %=mod;
				}
				for(int k = i-9 > 1? i-9 : 1; k<=i; k++)
				{
					Na[i][j] += Na[k][j-1];
					//Na[i][j] %=mod;
				}
			}
		}
		
		for(int j = 1;j<B[0].length ;j++)
		{
			for(int i=1; i<B.length; i++)
			{
				for(int k = i-9 > 0 ? i-9 : 0; k<=i ;k++)
				{
					B[i][j] += 10*B[k][j-1] + (i-k)*Nb[k][j-1];
				}
			}
		}
		
		for(int j=1; j<A[0].length; j++)
		{
			for(int i=1; i<A.length;i++)
			{
				for(int k = i-9 > 1 ? i-9: 1; k<=i ; k++)
				{
					A[i][j] += 10*A[k][j-1] + (i-k)*Nb[k][j-1];
				}
			}
		}
		
		long sum = 45;
		for(int j =1; j <= n/2; j++)
		{
			for(int i=1; i<= 9*(n/2);i++)
			{
				long mult = (long)Math.pow(10, j);
			}
		}
		return 0;
	}
	public static long Tbrute(int n)
	{
		long u = (long)Math.pow(10, n);
		long sum = 0;
		for(int i =1; i<u; i++)
		{
			
			if(prop(i)) sum+=i;
		}
		return sum;
	}
	
	public static boolean prop(int i)
	{
		//test if i satisfies the property
		String s = ""+i;
		int k = s.length();
		int copy = i;
		int d = k/2;
		int s1 = 0;
		for(int j=1; j<=d; j++)
		{
			s1+=copy%10;
			copy/=10;
		}
		if(k%2 == 1) copy/=10;
		int s2 = 0;
		for(int j=1; j<=d; j++)
		{
			s2+=copy%10;
			copy/=10;
		}
		return s1 == s2;
	}
}
