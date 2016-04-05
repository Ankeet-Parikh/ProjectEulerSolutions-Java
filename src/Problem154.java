
public class Problem154 {
	public static void main(String[] args)
	{
		int r = 200000;
		int[] f = new int[r+1]; //f[i] = # of fives in prime factorization of i!
		int[] t = new int[r+1]; //t[i] = # of fives in prime factorization of i!
		for(int i=1; i<=r; i++)
		{
			f[i] = f[i-1] + occ(5, i);
			t[i] = t[i-1] + occ(2, i);
		}
		
	}
	
	public static int occ(int p, int n)
	{
		//returns the number of times p occurs in the prime factorization of n
		int i = 0;
		while(n%p == 0)
		{
			i++;
			n/=p;
		}
		return i;
	}
}
