package problems_70_79;

public class Problem73 {
	public static void main(String[] args)
	{
		
		int count =0;
		for(int i =2; i<=12000; i++)
		{
			for(int j = i%3==0 ? i/3+1:(int)Math.ceil(i/3.0); j< i/2.0;j++)
			{
				if(gcf(i,j) ==1) 
					count++;
			}
		}
		System.out.println(count);
	}
	
	public static long gcf(long a, long b)
	{
		if(b == 0) return a;
		else return gcf(b, a%b);
	}
}
