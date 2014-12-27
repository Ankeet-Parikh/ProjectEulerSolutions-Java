

public class Problem46 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int value =0;
		boolean writtenAs =true;
		int i =3;
		while(writtenAs)
		{
			if(!isPrime(i))
			{
				if(!goldbach(i))
					writtenAs = false;
				value = i;
			}
			i+=2;
		}
		System.out.println(value);

	}
	public static boolean goldbach(int compositeNum)
	{
		for(int i =0; i< compositeNum; i++)
		{
			if(!isPrime(i))
				continue;
			else
			{
				for(int j=1; j <=(compositeNum-i)/2 ; j++)
				{
					if(compositeNum == i + 2*j*j)
						return true;
				}
			}
		}
		return false;
	}
	public static boolean isPrime(int num)
	{
		for(int i =2; i < Math.pow(num, 0.5); i++)
		{
			if(num%i==0)
				return false;
		}
		return true;
	}
	
}
