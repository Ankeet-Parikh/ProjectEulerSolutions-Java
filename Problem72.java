package problems_70_79;

public class Problem72 {
	public static void main(String [] args)
	{
		
		int range =1000000;
		System.out.println(sumtotientBatch(range));
		
	}
	public static long sumtotientBatch(int n)
	{
		long sum=0;
		int[] totients = new int[n+1];
		for(int i =0; i< totients.length; i++)
		{
			totients[i]=i;
		}
		totients[0] = 0;
		totients[1] = 0;
		for(int i =2; i<n+1; i++)
		{
			if(totients[i] ==i)
			{
				sum+=i-1;
				for(int j=i; j<n+1; j+=i)
				{
					totients[j] = totients[j] / i *(i-1);
				}
			}
			else sum+=totients[i];
		}
		return sum;
	}
}
