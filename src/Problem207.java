

public class Problem207 {

	
	public static void main(String[] args) {
		double k =2;
		double target = 1.0/12345.0;
		long perf =0; //number of perfcet partitions
		long part =0; //total number of partitions
	
		for(long i =4; ; i+=2)
		{
			double exp2t = (1+Math.round(Math.sqrt(1+4*k)))/2;
			double t = Math.round(Math.log(exp2t)/Math.log(2));
			if(Math.pow(2, t) == exp2t)
			{
				perf++;
				
			}
			part++;
			if(perf/(double)part <target)
				break;
			
			k+=i; 
		}
		System.out.println((long)k);
		
		
	}
	
	

}
