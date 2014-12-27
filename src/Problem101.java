

public class Problem101 {

	
	public static void main(String[] args) {
		
		long sumFits =0;
		int degree = 10;
		for(int i =1; i <= degree; i++)
		{
			long [] xVal = new long[i];
			long [] yVal = new long[i];
			for(int j =0; j< xVal.length; j++)
			{
				xVal[j] = j+1;
				yVal[j] = FORMULA(xVal[j]);
			}
			sumFits+=NextLagrange(xVal, yVal);
			
		}
		System.out.println(sumFits);
		
	}
	//Lagrange Interpolating Polynomial
	public static long NextLagrange(long[] xVal, long[] yVal)
	{
		double next = xVal.length +1;
		double fit =0;
		
		for(int l =0; l < xVal.length; l++)
		{	
			double Lx = yVal[l];
			for(int m =0; m < xVal.length; m++)
			{
				if(m == l) continue;
				else
				{
					Lx*= (next-xVal[m])/(xVal[l]-xVal[m]);
				}
			}
			fit +=Lx;
		}
		
		return (long)Math.round(fit);
	}
	
	public static long FORMULA(long n) //returns value of the number when substituted into real formula
	{
		
		long y =0;
		for(int i =0; i<=10;i++)
		{
			y+= Math.pow(-n, i);
		}
		return y;
		
	}
	

}
