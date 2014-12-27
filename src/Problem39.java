

public class Problem39 {

	
	public static void main(String[] args) {
		double startTime = System.currentTimeMillis();
		
		
		int[] numSolutions = new int[1000];
		int max =0;
		for(int p =1; p< 1000; p++)
		{
			for(int a = 1; a< p; a++)
			{
				for(int b =1; b < p; b++)
				{
					int c = p-(a+b);
					if(c*c == a*a+b*b)
						numSolutions[p]++;
					if(numSolutions[p] > max) max =p;
				}
			}
		}
		System.out.println(max);
		
		
		double stopTime = System.currentTimeMillis();
	      double elapsedTime = stopTime - startTime;
	      System.out.println("Time taken: " + (elapsedTime/1000) +" seconds");

	}

}
