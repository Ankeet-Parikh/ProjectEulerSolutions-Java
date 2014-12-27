package problems_210_219;

public class Problem214 {
	public static void main(String[] args)
	{
		
		int range =40000000;
		int[] totients = totientSieve(range);
		long sum =0;
		for(int i =2; i<totients.length; i= i==2 ? i+1 : i+2)
		{
			if(totients[i] == i-1) // primality test
			{
				
				int tcl = totientChainLength(totients, i);
				//System.out.println(i +"  " +tcl);
				if(tcl == 25)
					sum+=i;
			}
		}
		System.out.println(sum);
		
	}
	public static int totientChainLength(int[] totientBatch, int n)
	{
		int l =1;
		while(n != 1)
		{
			l++;
			n = totientBatch[n];
		}
		return l;
	}
	
	public static int[] totientSieve(int n)
	{
		int[] tot = new int[n+1];
		for(int i= 0; i<tot.length; i++)
		{
			tot[i] =i;
		}
		
		for(int i = 2; i<tot.length; i++)
		{
			if(tot[i] ==i )//primality test
			{
				for(int j = i; j<tot.length; j+=i)
				{
					tot[j] = tot[j] / i  * (i-1);
				}
			}
		}
		return tot;
	}
}
