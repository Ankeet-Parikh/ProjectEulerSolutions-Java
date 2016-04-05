

public class Problem258 {
	static long mod = 20092010;
	public static void main(String[] args)
	{
		System.out.println(test(70000));
	}
	public static long test(int n)
	{
		long[] g = new long[n+1];
		for(int i=0; i<=Math.min(n, 1999); i++) g[i] = 1;
		for(int i=2000; i<=n; i++) g[i] = g[i-2000] + g[i-1999];
		return g[n]%mod;
	}
	public static long solve(long n)
	{
		if(0 <=n && n<=1999) return 1;
		long[][] A = new long[2000][2000];
		for(int r=0; r<A.length; r++)
		{
			for(int c = 0; c < A[r].length; c++)
			{
				if(r == 0 )
				{
					A[r][c] = c == 1998 || c == 1999 ?1:0;
				}
				else
					A[r][c] = c == r-1?1:0;
			}
		}
		long[][] x = new long[2000][1];
		for(int i= 0; i<x.length; i++)
		{
			x[i][0] = 1;
		}
		
		//exponentiate A
		ModExp(A, n-2000);
		/*
		 * Multiply the first row of A by the column vector x and that is the result
		 */
		long res = 0;
		for(int r=0, c=0;c<2000;c++)
		{
			res+= (A[r][c] * x[c][0])%mod;
		}
		return res%mod;
	}
	
	public static long[][] ModExp(long[][] A, long e)
	{
		if(e == 0)
		{
			
			return I(A.length);
		}
		if(e%2 == 1)
		{
			return Multiply(A, ModExp(A, e-1));
		}
		else
		{
			
			long[][] D =  ModExp(A, e/2);
			return Multiply(D, D);
		}
	}
	
	public static long[][] Multiply(long[][] A, long[][] B)
	{
		//assume that they are of the same size
		long[][] C = new long[A.length][B[0].length];
		for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B[0].length; j++)
            {
                for (int k = 0; k < A[0].length; k++)
                    C[i][j] += (A[i][k] * B[k][j]) %mod;
                C[i][j] %=mod;
            }
        return C;
	}
	
	public static long[][] I(int n) //returns identity matrix of size n
	{
		long[][] Id = new long[n][n];
		for(int i=0; i<Id.length; i++)
				Id[i][i] = 1;
		return Id;
	}
	public static void Print(long[][] A)
	{
		for(int i =0; i<A.length; i++)
		{
			for(int j=0; j<A[i].length; j++)
			{
				System.out.print(A[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
