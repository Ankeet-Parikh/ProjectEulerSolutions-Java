package problems_110_119;
public class Problem116 {
	
	static long tileLength =2;
	static long totalBlocks = 50;
	
	public static void main(String[] args) 
	{
		long totalSolutions =0;
		for(tileLength =2;tileLength <=4;tileLength++)
		{ 
			for(int numTiles =1; numTiles*tileLength <= totalBlocks; numTiles++)
			{
				totalSolutions+= countPossib(numTiles+1, totalBlocks-numTiles*tileLength );
			}
			
		}
		System.out.println(totalSolutions);
		
	}
	
	public static long countPossib(long spots, long unused)
	{
		long p =0;
		if(spots == 2) 
			p = unused+1;
		else
		{
			for(int i =0; i<=unused; i++)
			{
				p+=countPossib(spots-1, unused-i);
			}
		}
		
		return p;
	}
	

}










