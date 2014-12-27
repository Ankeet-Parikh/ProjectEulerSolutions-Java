
public class Problem24 {

	public static void main(String[] args) {
		int[] arrange = {0,1,2,3,4,5,6,7,8,9}; 
		int nthValue =1000000;
		
		
		for(int i=1; i<=nthValue; i++)
		{	
			if(i == nthValue)PrintArray(arrange);
			int k =-1;
			for(int x = arrange.length-2; x>= 0; x-- )//step 1
			{
				if(arrange[x] < arrange[x+1])
				{
					k=x;
					break;
				}
			}
			if(k == -1) break;
			int l =-1;
			for(int x =arrange.length-1; x > k; x--)//step 2
			{
				if(arrange[k] < arrange[x])
				{
					l=x;
					break;
				}
			}
			
			int temp = arrange[k]; //step 3
			arrange[k] = arrange[l];
			arrange[l] =temp;
				
			for(int c = k+1, j = arrange.length-1; c<j; c++, j--)
			{
				int temp2 = arrange[c];
				arrange[c] = arrange[j];
				arrange[j] =temp2;
			}
	
			
		}
		

	}
	public static int[] method1()
	{
		return null;
	}
	public static void PrintArray(int[] array)
	{
		for(int i =0; i< array.length; i++)
			System.out.print(array[i]);
		System.out.println("");
	}
	
	

}
