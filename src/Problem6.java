
/*
http://projecteuler.net/problem=6
 */
public class Problem6 {

	
	public static void main(String[] args) {
		int squares = 0, sumSquare =0, range =100;
		for(int i = 1; i<= range; i++)
		{
			squares+= i*i;
			sumSquare+=i;
		}
		sumSquare*=sumSquare;
		
		System.out.println(sumSquareDifference(100));
	}
	//Does the calculation in O(1)
	public static long sumSquareDifference(long limit)
	{
		return (long)Math.pow(limit*(limit+1)/2, 2)- (2*limit+1)*(limit+1)*limit/6;
	}

}
