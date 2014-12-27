package problems_40_49;

public class Problem44 {

	
	public static void main(String[] args) {
		int difference =0;
		for(int j =2; ; j++)
		{
			boolean found =false;
			int Pj = j*(3*j-1)/2;
			for(int k =j-1;k>0 ; k--)
			{
				int Pk = k*(3*k-1)/2;
				if(isPentagonal(Pj+Pk) && isPentagonal((int)Math.abs(Pj-Pk)))
				{
					difference = Math.abs(Pj-Pk);
					found =true;
					break;
				}
			}
			if(found) break;
		}
		System.out.println(difference);

	}
	public static boolean isPentagonal(int num)
	{
		return (1+Math.pow(24*num+1,0.5))/6%1==0;
	}

}
