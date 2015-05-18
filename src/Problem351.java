
public class Problem351 {
	public static void main(String[] args)
	{
		long sum =0;
		int range = (int)1e8;
		
		int[] tot = new int[range+1]; 
		for(int i=0; i<tot.length; i++)tot[i] =i;
		for(int i=2; i<tot.length; i++)
		{
			if(tot[i] == i)
			{
				for(int j =i; j<tot.length; j+=i)
				{
					tot[j] = tot[j] / i * (i-1);
				}
			}
			sum+=(i-tot[i]);
		}
			
		System.out.println(6*sum);
	}
}
