
public class Problem92 {

	
	public static void main(String[] args) {
		/* Old solution without memoization: runs in 0.6 seconds
		 * 
		double s = System.currentTimeMillis();
		int total =0;
		for(int i =1; i< 10000000; i++)
		{
			int current =i;
			for(;;)
			{
				if(current == 89)
					total++;
				if(current == 1 || current ==89)
					break;
				current = nextVal(current);
			}
			
		}
		System.out.println(total);
		*/
		
		//Solution with memoization, runs in 0.2 seconds
		
		int r = 10000000;
		int[] e = new int[r];
		int n =0;
		for(int i=1; i<r; i++)
		{
			int c =i;
			while(true)
			{
				if(c ==1 || c==89)
				{
					e[i] =c;
					if(c ==89) n++;
					break;
				}
				c = nextVal(c);
				if(c<i)
					c = e[c];
			}
		}
		System.out.println(n);
	}
	
	public static int nextVal(int num)
	{
		int sum =0;
		while(num != 0)
		{
			int x = num%10;
			sum+= x*x;
			num/=10;
		}
		return sum;
	}

}

