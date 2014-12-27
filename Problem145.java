package problems_140_149;

public class Problem145 {

	
	public static void main(String[] args) {
		double s = System.currentTimeMillis();
		int reversibles =0;
		for(int i =0; i< 100000000; i++)
		{
			if(isReversible(i)) reversibles++;
		}
		System.out.println(reversibles);
		double e = System.currentTimeMillis();
		System.out.println((e-s)/1000 + " seconds");
	}
	
	public static boolean isReversible(int k)
	{
		if(k%10 == 0) return false;
		String reversed =new StringBuffer(Integer.toString(k)).reverse().toString();
		int sum = Integer.parseInt(reversed) + k;
		while(sum > 0)
		{
			if((sum %10)%2 ==0) return false;
			sum/=10;
		}
		return true;
	}

}
