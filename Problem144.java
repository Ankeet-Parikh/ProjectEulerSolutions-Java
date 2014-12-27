package problems_140_149;

public class Problem144 {

	public static void main(String[] args)
	{
		/*
		 * we need to find out how many times the beam reflects the mirror
		 * before exiting. To do this, we will calculate the points where the beam
		 * intersects the ellipse and then the direction it moves on.
		 * The intersection points are found through the quadratic formula 
		 * and the direction of the beam afterwards is found through the 
		 * householder reflection. hu(x) = x - 2(dot(x,u))u
		 * 
		 * Procedure:
		 * 		1. compute next intersection point
		 *      start at point x0 = (1.4, -9.6)
		 *      and direction v = (16.459067357512954, -10.915544041450778)
		 *      find m, the slope as v[1]/v[0];
		 *      find b, the y intercept as x0[1]-m*x0[0]
		 *      find the roots of (4+m*m)x^2 + 2*m*b*x + b*b-100=0;
		 *      find the y values of the x values just found
		 *      and choose the next point (the other point will be the one just visited)
		 *      2. See if the beam leaves the ellipse, 
		 *      if it does, break
		 *   	else go to 3
		 *      3. compute the direction of reflection
		 *      find the unit tangent u = (y,-4x)
		 *      perform the householder reflection to v with respect to u
		 *      
		 *      
		 *      
		 */
		
		long count=1;
		double[] x = {1.4,-9.6}; //starting point of beam (this is the first intersection)
		double[] v = {16.459067357512954, -10.915544041450778};//direction of beam
		
		for(;;)
		{
			//find the intersection
			double m = v[1]/v[0];
			double b = x[1]-m*x[0];
			double[] q = quadroots(4+m*m, 2*m*b, b*b-100);
			if(Math.abs(q[0]-x[0]) < 1e-7)
				x[0] = q[1];
			else
				x[0] = q[0];
			x[1] = m*x[0]+b;
			
			//see if the beam leaves the ellipse
			if(x[0]<=0.01 && x[0]>=-0.01 && x[1]>0)
				break;
			//do the householder
			double[] u = {x[1], -4*x[0]};
			u = scalar(u, 1/magnitude(u));
			v = householder(u, v);
			count++;
		}
		System.out.println(count);
		
	}
	public static double[] householder(double[] u, double[] x)
	{
		return add(x, scalar(u,-2*dot(x,u)));
	}
	public static double[] quadroots(double a, double b, double c)
	{
		double[] roots = new double[2];
		double dis = b*b-4*a*c;
		if(dis <0 )
			return null;
		roots[0]= (-b + Math.sqrt(dis))/(2*a);
		roots[1]= (-b - Math.sqrt(dis))/(2*a);
		return roots;
	}
	
	public static double[] add(double[] a, double[] b) //adds two vectors
	{
		double[] n = new double[a.length];
		for(int i=0; i<n.length; i++)
			n[i] = a[i]+b[i];
		return n;
	}
	public static double dot(double[] a, double[] b)//dot product of 2 vectors
	{
		double p =0;
		for(int i=0; i<a.length; i++)
		{
			p+=a[i]*b[i];
		}
		return p;
	}
	public static double[] scalar(double[] a, double s) //multiply a vector times scalar
	{
		for(int i=0; i<a.length; i++)
		{
			a[i]*=s;
		}
		return a;
	}
	
	public static double magnitude(double[] a)
	{
		double m=0;
		for(int i=0; i<a.length; i++)
		{
			m+=Math.pow(a[i],2);
		}
		return Math.sqrt(m);
	}
}
