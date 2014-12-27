
public class Problem112 {


	public static void main(String[] args) {
		long numBouncy =0, finalIndex =0;
		
		
		for(long i =1; ;i++)
		{
			if(isBouncy(i))numBouncy++;
			if((double)numBouncy/i == 0.99)
				{
				finalIndex =i;
				break;
				}
		}
		System.out.println(finalIndex);

	}
	public static boolean isBouncy(long num)
	{
		String s = String.valueOf(num);
		boolean isIncreasing = true, isDecreasing = true;
		
		for(int i =0; i< s.length()-1; i++)
		{
			int curr =Integer.parseInt(s.substring(i,i+1)), next = Integer.parseInt(s.substring(i+1,i+2));
			if(curr > next)
				isIncreasing = false;
			if(curr < next)	
				isDecreasing =false;
			if(!isIncreasing && !isDecreasing)break;
		}
		return !isIncreasing && !isDecreasing;
	}
	

}
