package problems_110_119;

public class Problem113 {

	
	public static void main(String[] args) {
		int sum =0;
		for(int i =1; i<=8; i++ )
		{
			sum+=m(i);
		}
		System.out.println(sum);

	}
	
	public static int m(int k)
	{
		double exp2 = Math.log(k)/Math.log(2);
		if(exp2%2==0) return (int)exp2;
		
		else return 0;
	}

}
