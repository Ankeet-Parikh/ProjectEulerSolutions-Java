
public class Problem121 {
	/*
	 * For this problem, take the sum of all the probabilities of each winning scenario.
	 * For example, the 4 turn case:
	 * The first turn there is 1 red and 1 blue disc, blue probability is 1/2
	 * Second turn there are 2 red and 1 blue, blue probability is 1/3
	 * Generalizing this, on the nth turn, there are n red discs and 1 blue disc, making the 
	 * probability of picking a blue disc 1 over n.
	 * 
	 * For the n=4 case, we can win if we pick 3 blue discs, or 4 blue discs
	 * Lets say we pick a blue disc on the first, second, and fourth turn, and pick a red on the third,
	 * the probability of this happening is:
	 * 1/2 * 1/3 * 3/4 * 1/5  = 3/120
	 * 
	 * Here are all of the winning scenarios for 4 turns:
	 * 1/2 * 1/3 * 1/4 * 4/5 = 4/120
	 * 1/2 * 1/3 * 3/4 * 1/5 = 3/120
	 * 1/2 * 2/3 * 1/4 * 1/5 = 2/120
	 * 1/2 * 1/3 * 1/4 * 1/5 = 1/120 (On the first turn, we pick a red disc)
	 * 1/2 * 1/3 * 1/4 * 1/5 = 1/120 (On every turn, we pick a blue disc)
	 * The sum of all these is 11/120
	 * Call this probability p
	 * 
	 * In order to find the amount we should allocate, we need to find the 
	 * largest integer n such that n*p < 1
	 */
	public static void main(String[] args)
	{
		int n = 15;
		int wb = n/2 +1; //minimum number of blue discs needed to win
		double prob = 0;
		for(int i = 0;i < Math.pow(2,n);i++)
		{
			if(Integer.bitCount(i) >= wb)
			{
				String bin = Integer.toBinaryString(i);
				//System.out.println(bin);
				double cp = 1;
				int k = n+1;
				for(int j = bin.length()-1; j>=0 ;j--, k--)
				{
					if(bin.charAt(j) == '1')
					{
						cp = cp/k;
					}
					else
					{
						cp = cp*(k-1)/k;
					}
				}
				while(k > 1)
				{
					cp = cp * (k-1) / k;
					k--;
				}
				//System.out.println(cp);
				prob+=cp;
			}
		}
		System.out.printf("%.15f\n", prob);
		System.out.println((long)(1/prob));
	}
}
