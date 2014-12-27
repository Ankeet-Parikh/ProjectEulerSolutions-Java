

public class Problem31 {

	static int[] coins = {200, 100, 50, 20, 10, 5, 2 , 1  };
	static int[] coins2 = {1,2,5,10,20,50,100,200};
	public static void main(String[] args) {
		
		
		System.out.println(ways2(2000));
	}
	
	public static long ways(long target, int curr)
	{
		long tot =0;
		//the combinations of 2 and 1 coins to produce large targets is very hefty,
		//the formula below simplifies that
		if(curr == 6) return (target+2)/coins[curr]; 
		for(int i=0; i*coins[curr]<=target; i++)
		{
			tot+=ways(target-i*coins[curr], curr+1);
		}
		return tot;
	}
	public static long ways2(int target)
	{
		long[] ways = new long[target+1];
		ways[0] =1;
		for(int i =0; i<coins2.length; i++)
		{
			for(int j =coins2[i]; j<ways.length; j++)
			{
				ways[j] += ways[j-coins2[i]];
			}
		}
		return ways[ways.length-1]; //last element, effectively the target
	}

}
