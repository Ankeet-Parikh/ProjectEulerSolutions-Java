
public class Problem308 {
	static long[] n = {17, 78, 19, 23, 29, 77, 95, 77, 1, 11, 13, 15, 1, 55};
	static long[] d = {91, 85, 51, 38, 33, 29, 23, 19, 17, 13, 11, 2, 7, 1};
	public static void main(String[] args)
	{
		
		long s = 2;
		for(int i=1; i<1000; i++)
		{
			s= iter(s);
			System.out.println(" " + s);
		}
		
	}
	
	public static long iter(long s)
	{
		for(int i =0; i<n.length; i++)
		{
			if(s%d[i] == 0)
			{
				System.out.print(i);
				return s/d[i]*n[i];
			}
		}
		return -1;
	}

}
