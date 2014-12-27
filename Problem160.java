package src;

public class Problem160 {

	
	public static void main(String[] args) {
		long N = 1000000000000L;
		long fac = 1;
		long mod =100000;
		for(;N>1; N--)
		{
			fac=(fac%mod)*N;
			while(fac%10==0)
			{
				fac/=10;
			}
			fac%=mod;
		}
		System.out.println(fac);

	}

}
