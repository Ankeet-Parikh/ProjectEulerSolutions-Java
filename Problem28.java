package problems_20_29;

public class Problem28 {

	
	public static void main(String[] args) {
		int spiralSide =1001;
		long sum =1;
		for(int add = 2, i=1 ; i< Math.pow(spiralSide,2) ; add+=2)
		{
			for(int j =0; j< 4; j++)
			{
				sum+=i+add;
				i=i+add;

			}
		}
		System.out.println(sum);
	}

}
