
public class Problem186 {
	static int Parent[] = 
	public static void main(String[] args)
	{
		int mod = 1000000;
		int[] s = new int[56];
		for(int k=1; k<=55; k++)
		{
			s[k] = (int)((100003 - 200003l * k + 300007l *k*k*k )%mod);
		}
		System.out.println(s[6]);
	}
	
	public int find(int i)
	{
		
	}
}
