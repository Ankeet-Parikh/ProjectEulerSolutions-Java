
public class Problem411 {
	public static void main(String[] args)
	{
		int k = 22;
		S(k);
		
	}
	
	public static int S(int n)
	{
		int[][] st = new int[2*n+1][2];
		st[0][0] = 1;
		st[0][1] = 1;
		for(int i = 1; i<=2*n; i++)
		{
			st[i][0] = (int) (((long)(2) * st[i-1][0])%n);
			st[i][1] = (int) (((long)(3) * st[i-1][0])%n);
		}
		return 0;
		
	}
}
