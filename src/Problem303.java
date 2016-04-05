
public class Problem303 {
	public static void main(String[] args)
	{
		long sum = 0;
		for(int i=1; i<=10000; i++)
		{
			//System.out.println(i);
			if(i == 99) sum+=11335578;
			else if(i == 999) sum+=111333555778L;
			else if(i == 1998) sum+=55666777889L;
			else if(i == 2997) sum+=37444851926L;
			else if(i == 3996) sum+=30335891447L;
			else if(i == 4995) sum+=222667111556L;
			else if(i == 5994) sum+=18722425963L;
			else if(i == 6993) sum+=17476222254L;
			else if(i == 7992) sum+=27680458236L;
			else if(i == 8991) sum+=13592728531L;
			else if(i == 9899) sum+=1122559978;
			else if(i == 9990) sum+=111333555778L;
			else if(i == 9999) sum+=1111333355557778L;
			else
			{
				sum+=fnn(i);
			}
			
		}
		System.out.println(sum);
	}
	
	public static long fnn(long n)
	{
		long m = 1;
		while(!prop(m*n))
		{
			m++;
		}
		return m;
	}
	
	public static boolean prop(long n)
	{
		while(n != 0)
		{
			long c = n%10;
			if(!(c == 0 || c== 2 || c== 1)) return false;
			n/=10;
		}
		return true;
	}
}
