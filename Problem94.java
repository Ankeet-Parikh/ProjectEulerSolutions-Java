package problems_90_99;



public class Problem94 {

	
	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		
		long sumPerimeters =0, limit = (long)Math.pow(10,9);
	
		for(long a =0;; a++)
		{
			
			long p = 3*a-1; //p is perimeter
			if(sumPerimeters + p > limit) break; 
			if(isAreaIntegral(a,a,a-1)) 
			{
				sumPerimeters += p; 
				//System.out.println(a +" " + a + " " + (a-1));
				//System.out.println(sumPerimeters);
			}
			
			p = 3*a+1;
			if(sumPerimeters + p > limit) break;
			if(isAreaIntegral(a,a,a+1)) 
			{
				sumPerimeters +=p;
				//System.out.println(a +" " + a + " " + (a+1));
				//System.out.println(sumPerimeters);
			}
			
		}
		
		System.out.println(sumPerimeters);
		
		double end =System.currentTimeMillis();
		System.out.println((end-start)/1000.0 + " seconds to execute.");
	}
	public static boolean isAreaIntegral(long a, long b, long c)
	{
		double s = (a+b+c)/2.0;
		double area = Math.pow(s*(s-a)*(s-b)*(s-c),0.5000000000000);
		
		return area > 0.0 && area%1.0==0.0;
	}
	
	
}
