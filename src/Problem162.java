
public class Problem162 {
	public static void main(String[] args)
	{
		int l = 5;
		int ct = 0;
		long k = 1;
		for(int i=1; i<=5; i++) k*=16;
		System.out.println(Long.toString(k, 16));
		for(int i=1; i<k; i++)
		{
			String s = Integer.toString(i, 16);
			if(s.contains("a") && s.contains("0") && s.contains("1"))
			{
				System.out.println(i + " " + s);
				ct++;
			}
		}
		System.out.println(ct);
	}
	
	public static long dpcount()
	{
		
	}
}
