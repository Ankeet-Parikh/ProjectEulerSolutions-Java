package src;

public class Problem179 {

	
	public static void main(String[] args) {
	int range = 10000000, count=0;
	int[] numDivisors = new int[range+1];
	numDivisors[0] = 0;
	
	for(int i =2; i<= range; i++)
	{
		for(int j =2; j*i<=range; j++)
		{
			numDivisors[i*j]++;
		}
	}
	for(int n = 2; n< numDivisors.length-1; n++)
	{
		if(numDivisors[n] == numDivisors[n+1])
			count++;
	}
	System.out.println(count);

	}

}
