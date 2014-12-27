

import java.util.ArrayList;

public class Problem50 {

	
	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		int maxLength =0, maxPrime =0, range =1000000;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum =0;
		for(int i =0; sum<= range ; i++ )
		{
			if(sum+i > range ) break;
			if(isPrime(i))
			{
				list.add(i);
				sum+=i;
				//System.out.println(i);
			}
			
			
		}
		//System.out.println(sum);
		while(!isPrime(sum) || sum > range){
			int temp = list.get(0);
			sum-=temp;
			list.remove(0);
		}
		System.out.println(sum);
		
	}
	
	
	public static boolean isPrime(int num)
	{
		if(num == 0 || num ==1 || (num%3==0 &&num!=3) ||(num%2==0 &&num !=2)) return false;
		for(int i =2; i<= Math.pow(num,0.5); i++)
		{
			if(num%i==0)return false;
		}
		return true;
	}

}
