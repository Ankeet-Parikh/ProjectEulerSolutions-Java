
//http://projecteuler.net/problem=9

public class Problem9 {
	public static void main(String[] args) {
		int a=200;
		int b=200;
		int c = (int) Math.pow(a*a+b*b, 0.5);
		
		while(a+b+c != 1000)
		{
			a++;
			if(a==1000)
			{
				a=1; b++;
			}
			c = (int) Math.pow(a*a+b*b, 0.5);
		}
		
		System.out.println(a*b*c);
		
		/* alternate
		double b =1;
		double a =1;
		while(true)
		{
			a = (1000*1000-2000*b)/(2000-2*b);
			if(a%1==0) break;
			b++;
		}
		//c = 1000-(a+b)
		System.out.println((int)(a*b*(1000-a-b)));
		*/
	}

}
