import java.util.ArrayList;



public class Problem500 {
	public static void main(String[] args)
	{
		
		boolean[] p = new boolean[7376507];
		for(int i=2; i<p.length; i++) p[i] = true;
		for(int i=2; i<p.length; i++)
			for(int j= 2*i; j<p.length; j+=i)
				p[j]=false;
		ArrayList<Long> pr = new ArrayList<Long>(0);
		
		for(int i =2; i<p.length; i++)
			if(p[i])
			{
				pr.add((long)i);
			}
		ArrayList<Long> used = new ArrayList<Long>(0);
		long n =1, mod = 500500507;
		int target = 500500;
		for(int i=0, s=0; i<pr.size(); )
		{
			if(used.size() ==s || pr.get(i)<used.get(s)*used.get(s))
			{
				n*=pr.get(i);
				n%=mod;
				used.add(pr.get(i));
				i++;
			}
			else
			{
				long sq = used.get(s)*used.get(s);
				n*=sq;
				used.add(sq);
				s++;
				n%=mod;
			}
			if(i+s == target)break;
				
		}
		//System.out.println(used);
		System.out.println(n);		
	}

}

