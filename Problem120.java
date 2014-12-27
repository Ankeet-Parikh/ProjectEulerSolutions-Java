package src;

public class Problem120 {

	
	public static void main(String[] args) {
		long sumRmax =0;
		
		for(long i =3; i<=1000; i++)
		{
			sumRmax+= 2*i*((i-1)/2);
		}
		System.out.println(sumRmax);
		

	}

}
