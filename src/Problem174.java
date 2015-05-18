
public class Problem174 {
	public static void main(String[] args)
	{
		int range = 1000000;
		int[] l = new int[range+1];
		for(int i =1; i< range+1 ; i++)
		{
			for(int j = i+2; j < range+1; j+=2)
			{
				int index = j*j-i*i;
				if(index > range) break;
				l[index]++;
			}
		}
		int  c = 0;
		for(int i=0; i<l.length; i++)  if(l[i] <= 10 && l[i] >=1) c++;
		System.out.println(c);
	}
}
