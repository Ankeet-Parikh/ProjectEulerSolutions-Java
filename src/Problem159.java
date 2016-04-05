
public class Problem159 {
	public static void main(String[] args)
	{
		int range = 1000000;
		int[] mdrs = new int[range];
		//initialize all to digital root
		for(int i =1; i<mdrs.length; i++)
		{
			mdrs[i] = i - 9 * ((i-1)/9);
		}
	
		for(int i =2; i < Math.sqrt(range);i++)
		{
			for(int j = i; i*j < range; j++)
			{
				int m = mdrs[i] + mdrs[j];
				mdrs[i*j] = (int)Math.max(m, mdrs[i*j]);
			}
		}
		long sum = 0;
		for(int i=2; i<range; i++)
			sum+=mdrs[i];
		System.out.println(sum);
	}
	
}
