package problems_140_149;

public class Problem148 {
	public static void main(String[] args)
	{
		double[] row = {1};
		int div =7;
		for(int i=1; i<=100;i++)
		{
			//count how many numbers in the row are not divisible by 7
			int count  =0;
			for(int j=0; j<row.length; j++)
			{
				assert(row[j] > 0);
				if(row[j]%7!=0)
					count++;
			}
			//Print(row);
			System.out.println("Row " +i + ":  " + count);
			
			//create new row
			double[] n = new double[row.length+1];
			for(int j=0; j < n.length; j++)
			{
				if(j==0 || j==n.length-1)
					n[j] =1;
				else
					n[j] = row[j-1]+row[j];
			}
			row =n;
		}
	}
	
	public static void Print(double[] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] +" ");
		}
		
		System.out.println("");
	}
}
