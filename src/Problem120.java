
public class Problem120 {
	public static void main(String[] args)
	{
		// Let us look at values of (a-1)^n + (a+1)^n modulo a^2
		// n = 1: a-1+a+1 = 2a
		// n = 2: a^2-2a+1 +a^2 + 2a + 1 = 2a^2 + 2 -> 2
		// n = 3: 2a^3 + 6a -> 6a
		// n = 4: 2a^4 + 12a^2 + 2 -> 2
		// n = 5: 2a^5 + 20a^3 + 10a -> 10a
		// n = 6: 2a^6 + 30a^4 + 30a^2 + 2 -> 2
		// n = 7: 2a^7 + 42a^5 + 70a^3 + 14a -> 14a
		// It looks like for even values of n, the remainder is 2
		// For odd values, the remainders are
		// 2a, 6a, 10a, 14a, 18a, ...
		// where the coefficients of a increase by 4 each time
		// can we prove these statements?
		long sum = 0; 
		for(int a=3; a<=1000; a++)
		{
			int max = 2;
			boolean[] rem = new boolean[a*a];
			for(int i=2; ;i+=4)
			{
				int r = (i*a)%(a*a);
				if(rem[r])
				{
					sum+=max;
					break;
				}
				else
				{
					max = r > max ? r : max;
					rem[r] = true;
				}
			}
		}
		System.out.println(sum);
	}
}
