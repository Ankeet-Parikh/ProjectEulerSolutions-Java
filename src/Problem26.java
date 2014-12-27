

public class Problem26 {
	public static void main(String[] args)
	{
		
		long maxNum=0, maxCycle=0;
		for(int i=2; i<1000; i++)
		{
			int c = cycleLength(i);
			if(c > maxCycle)
			{
				maxCycle=c;
				maxNum=i;
			}
		}
		System.out.println(maxNum);
		
	
	}
	
	public static int cycleLength(int n)
	{
		int l=0;
		int[] remainders = new int[n];
		for(int remain =1, i=0;;i++)
		{
			remain %= n;
			if(remain ==0) return 0; //this indicates the decimal terminates
			
			for(int j=0; j<i; j++) //check if value has come up before
			{
				if(remainders[j] == remain)
					return l-j;
			}
			
			remainders[i] =remain;
			l++;
			remain*=10;
		}
		
	}
	
}
