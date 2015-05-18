import java.util.*;
public class Problem197 {
	public static void main(String[] args)
	{
		ArrayList<Double> m = new ArrayList<Double>(0);
		double u = -1;
		for(int i = 1; i< 1000; i++)
		{
			if(m.contains(u))
			{
				System.out.println("repeating");
				System.out.printf("Answer: %.9f\n", u+f(u));
			}
			else
				m.add(u);
			System.out.println(u);
			System.out.println("~~~~~~~~~~~~~");
			u = f(u);
		}
	}
	
	public static double f(double x)
	{
		return Math.floor(Math.pow(2.0, 30.403243784-x*x))*1e-9;
	}
}
