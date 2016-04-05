
public class Problem108 {
	public static void main(String[] args)
	{
		//number of solutions to 1/x+1/y = 1/n is equal to 
		//(a+1)/2 where a is the number of divisors of n^2
		double s = System.currentTimeMillis();
		for(int i = 5;;i++)
		{
			int q = numdivnsq(i);
			if((q+1)/2 > 1000)
			{
				System.out.println(i);
				break;
			}
		}
		double e = System.currentTimeMillis();
		System.out.println((e-s)/1000 + " seconds");
	}
	
	public static int numdivnsq(int n)
	{
		//returns the number of divisors of n^2
		int tot = 1;
		for(int i = 2; i<=n; i++)
		{
			int pc = 0; //prime count
			while(n%i == 0)
			{
				pc++;
				n/=i;
			}
			if(pc > 0)
			{
				pc = 2*pc + 1;
				tot*=pc;
			}
		}
		return tot;
	}

}
