package problems_250_259;
import java.text.DecimalFormat;
import java.util.*;

public class Problem255 {

	public static void main(String[] args) {
		
		 double digits=14; 
		 double x_0; 
		 if(digits%2==0) 
		 { 
			x_0=7*Math.pow(10,(digits-2)/2); 
		 } 
		 else 
		 { 
			x_0 =2*Math.pow(10,(digits-1)/2); 
		} 
		 
		 double sum=SumOverInterval(Math.pow(10, digits-1),Math.pow(10,digits)-1 , x_0, 1);
		 
		 double ans = (double) sum/(9*Math.pow(10, digits-1));
		 DecimalFormat df = new DecimalFormat("#.0000000000");
		 System.out.println(df.format(ans));
		 
		
		
	}

	// gives sum of iterations(n) lower<=n<=upper, lower and upper must contain
	// same # of digits
	public static double SumOverInterval(double lower, double upper, double x, double i)
	{
		double sum =0;
		double lowerXMult = Math.ceil(lower/x)*x; //lowest multiple of x greater than lower
		
		for(double l =lower, u =(lowerXMult > upper) ?upper :lowerXMult; u<=upper; )
		{
			double xNext = Math.floor((x + Math.ceil((double) u / x)) / 2.0);
			if(xNext == x)
			{
				sum+=i*(u-l+1);
			}
			else
			{
				sum+=SumOverInterval(l,u,xNext,i+1);
			}
			
			l = u+1;
			
			if(u+x >= upper && u !=upper) u = upper;
			else u+=x;
		}
		return sum;
	}
}
