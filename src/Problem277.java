
public class Problem277 {
	public static void main(String[] args)
	{
		String t = "DdDddUUdDD";
		for(long i =1000000; ;i++)
		{
			if(correspondsTo(i,t))
			{
				System.out.println(i);
				break;
			}
		}
	}
	
	public static boolean correspondsTo(long n, String s)
	{
		String r = "";
		while(n != 1)
		{
			if(n%3 == 0) 
			{
				r+="D";
				n = n/3;
			}
			else if(n%3 == 1)
			{
				r += "U";
				n = (4*n+2)/3;
			}
			else if(n%3 ==2)
			{
				r+= "d";
				n = (2*n-1)/3;
			}
	
		}
		//System.out.println(r);
		return s.equals(r);
	}
}
