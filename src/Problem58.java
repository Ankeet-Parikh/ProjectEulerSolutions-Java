
import java.util.ArrayList;

public class Problem58 {

	
	public static void main(String[] args) {
		ArrayList<Long> diagonalList = new ArrayList<Long>();
		diagonalList.add((long) 1);
		double lowerThreshhold = 0.1;
		int numPrimes =0;
		for(long i =1, n =2; ;n+=2)
		{
			for(int j =0; j < 4; j++)
			{
				i+=n;
				if(isPrime(i)) numPrimes++;
				diagonalList.add(i);
			}
			//for(int j =0 ;j < diagonalList.size() ; j++) System.out.print(diagonalList.get(j)+" "); System.out.println(" ");
			
			if(numPrimes/(double)diagonalList.size() < lowerThreshhold) break;
		}
		
		System.out.println((diagonalList.size()+1)/2);

	}
	public static boolean isPrime(long num)
	{
		if(num ==0 || num ==1) return false;
		for(int i =2; i<= Math.pow(num,0.5); i++)
			if(num%i==0)return false;
		return true;
	}

}
