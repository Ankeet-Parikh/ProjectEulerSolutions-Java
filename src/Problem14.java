
public class Problem14 {
	
	
	
	public static void main(String[] args) {
		
		int range =1000000;
		long max =0, maxChain =0;
		int[] c = new int[range+1];
		c[0] =0;
		
		for(int i=1; i<c.length; i++)
		{
			if(i==1)
			{
				c[i] =1;
				continue;
			}
			else
			{
				long l =i;
				while(l >= i)
				{
					c[i]++;
					if(l%2==0) l/=2;
					else l = 3*l+1;
				}
				c[i]+=c[(int)l];
			}
			
			if(c[i] > maxChain)
			{
				max =i;
				maxChain = c[i];
			}
		
		}
	
		System.out.println(max);
		
		
	}
	
	//unused method
	/*
	public static long ChainLength(long num)
	{
		
		long length =1;
		
		while(num != 1)
		{
			length++;
			if(num%2==0) num/=2;
			else num = 3*num+1;
		}
		return length;
	}
	*/
	

}

