
public class Problem491 {
	public static void main(String[] args)
	{
		ArrayList<String> used = new arr
		long ans = 0;
		for(int i=0; i< 1<<20; i++)
		{
			if(Integer.bitCount(i) == 10) //numbers to add
			{
				int zero = 0;
				int addsum = 0;
				int occadd[] = new int[10], occsub[] = new int[10];
				for(int j = 0; j<20; j++)
				{
					if((i & (1<<j)) != 0)
					{
						occadd[(j)/2]++;
						addsum+=(j)/2;
					}
				}
				for(int j=0; j<10; j++) occsub[j] = 2-occadd[j];
				int subsum = 90-addsum;
				if((addsum-subsum)%11 == 0)
				{
					long add = 3628800;
					if(occadd[0] == 1) add=(add/10)*81;
					if(occadd[0] == 2) add=(add/90)*64;
					for(int j = 1; j<10; j++) add/=(occadd[j]>0? occadd[j] : 1);
					
					long sub = 3628800;
					for(int j = 0; j<10; j++) sub/=(occsub[j]>0? occsub[j] : 1);
					ans+=add*sub;
				}
			}
		}
		System.out.println(ans);
		
	}
	
	
}
