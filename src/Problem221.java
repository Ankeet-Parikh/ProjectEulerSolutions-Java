import java.util.*;
public class Problem221 {
	public static void main(String[] args)
	{
		ArrayList<Long> a = new ArrayList<Long>(0);
		boolean f = false;
		for(long p = 1; p < 25000 ;p++)
		{
			long k = p*p+1;
			for(int i = 1; i<=p; i++)
			{
				if(k%i == 0)
				{
					a.add(p * (p+i) * (p+k/i) );
					if(a.size() == 150000)
					{
						f = true;
						break;
					}
				}
				if(f) break;
			}
		}
		
		Collections.sort(a);
		System.out.println(a.get(a.size()-1));
		//4691967608692980
	}
}
