


public class Problem69 {

	
	public static void main(String[] args) {
		
		
		double maximum =0, maxNum =0;
		long range = 1000000;
		long totientList[] = totientGenerate(range);
		
		for(int i =2; i< totientList.length; i++)
		{
			//System.out.println(i + ": " +totientList[i]);
			double div = (double)i/totientList[i];
			if(div > maximum)
			{
				maximum = div;
				maxNum = i;
			}
		}
		System.out.println((long)maxNum);
		
	
	}
	
	
	public static long[] totientGenerate(long num)//returns array of totients for 0<=i<=num
	{
		long[] totients = new long[(int) (num+1)];
		for(int i =0; i< totients.length; i++)
		{
			totients[i] =i;
		}
		for(int i =2; i<=num; i++)
		{
			if(totients[i] ==i)
			for(int j =i; j<=num; j+=i)
			{
				totients[j]=totients[j] / i * (i-1);
			}
		}
		return totients;
	    
	}


}
