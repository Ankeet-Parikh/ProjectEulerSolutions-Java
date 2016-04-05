
public class Problem205 {
	public static void main(String[] args)
	{
		//p[i] = # of ways pete can make a sum of i
		int p[] = new int[37];
		//c[i] = # of ways colin can make a sum of i
		int c[] = new int[37];
		for(int i=0; i<262144; i++)
		{
			int s = 9; //sum
			int k = i;
			while(k > 0)
			{
				s+=k%4;
				k/=4;
			}
			p[s]++;
		}
		for(int i=0; i<46656; i++)
		{
			int s = 6;
			int k = i;
			while(k > 0)
			{
				s+=k%6;
				k/=6;
			}
			c[s]++;
		}
		double sump = 262144, sumc = 46656;
		double pr = 0;
		for(int i=9; i<37; i++)
		{
			double cpr = p[i]/sump;  //probability that pete rolls i
			double ccr = 0; //probability that colin rolls less than i
			for(int j = 0; j<i; j++)
			{
				ccr+=c[j];
			}
			ccr/=sumc;
			pr+=cpr*ccr;
		}
		System.out.printf("%.7f", pr);
		
		
	}

	
}
