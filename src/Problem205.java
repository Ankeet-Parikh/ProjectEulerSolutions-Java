
public class Problem205 {
	public static void main(String[] args)
	{
		int p =0;
		
		int t = 50000;
		for(int j =1; j<=t; j++)
		{
			int pt = 0, ct =0;
			for(int i=1; i<=9; i++) pt+=(int)(Math.random()*4)+1;
			for(int i=1; i<=6; i++) ct+=(int)(Math.random()*6)+1;
			if(pt > ct) p++;
		}
		System.out.println((double)p/t);
	}
	
}
