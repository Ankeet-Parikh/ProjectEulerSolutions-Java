import java.util.*;
public class Problem165 {
	static int[][] l = new int[0][0];
	public static void main(String[] args)
	{
		//each l is of the form {x1, y1, x2, y2} where x1<=x2
		System.out.println(fI(new int[]{6,3, 2, 3}, new int[]{1,2,4,4}));
		l = new int[5000][4];
		long s = 290797;
		for(int i=1; i<=5000*4; i++)
		{
			int r = (i-1)/4;
			int c = (i-1)%4;
			s = (s*s) % 50515093;
			int t = (int)(s%500);
			l[r][c] = t;
			
		}
		
		
		ArrayList<Long[]> pts = new ArrayList<Long[]>(0);
		ArrayList<Long[]> pts2 = new ArrayList<Long[]>(0);
		for(int i=0; i<l.length-1; i++)
		{
			for(int j=i+1; j<l.length; j++)
			{
				Long[] pt = findIntersection(l[i], l[j]);
				if(pt != null)
				{
					pts.add(pt);	
				}
				Long[] pt2 = fI(l[i], l[j]);
				if(pt2 != null)
				{
					pts2.add(pt2);
				}
			
			}
		}
		System.out.println(pts.size());
		System.out.println(pts2.size());
		
		
		
	}
	//returns "" if no intersection, otherwise
	//"nx/dx,ny/dy" where nx is the numerator for the x coordinate, dx is denominator,...
	//numerators hold the negative sign
	//l1 = {x1, y1, x2, y2}
	public static Long[] findIntersection(int[] l1, int[] l2)
	{
		if(l1[0] > l1[2]) l1 = new int[]{l1[2], l1[3], l1[0], l1[1]};
		if(l2[0] > l2[2]) l2 = new int[]{l2[2], l2[3], l2[0], l2[1]};
		long m1n = l1[3]-l1[1];
		long m1d = l1[2]-l1[0];
		long g = gcd(m1n, m1d);
		m1n/=g;
		m1d/=g;
		if(m1d < 0) { m1d*=-1; m1n*=-1;}
		
		long m2n = l2[3]-l2[1];
		long m2d = l2[2]-l2[0];
		g = gcd(m2n, m2d);
		m2n/=g;
		m2d/=g;
		if(m2d < 0) { m2d*=-1; m2n*=-1;}
		
		if(m1d == m2d && m1n == m2n) return null; //if the slopes are the same, there is no true intersection point
		
		//x coordinate of intersection
		long ixn = (l1[1]-l2[1])*m1d*m2d - m1n*m2d*l1[0] + m1d*m2n*l2[0];
		long ixd = m2n*m1d-m1n*m2d;
		
		g = gcd(ixn, ixd);
		ixn/=g;
		ixd/=g;
		if(ixd < 0 ) {ixd*=-1; ixn*=-1;}
		//System.out.println(ixn + " " + ixd);
		//y coordinate of intersection
		long iyn = (l1[0]*l1[3]-l1[1]*l1[2])*(l2[1]-l2[3])-(l1[1]-l1[3])*(l2[0]*l2[3]-l2[1]*l2[2]); //(x1y2-y1x2)*(y3-y4)-(y1-y2)*(x3y4-y3x4)
		long iyd = (l1[0]-l1[2])*(l2[1]-l2[3])-(l1[1]-l1[3])*(l2[0]-l2[2]); //(x1-x2)*(y3-y4)-(y1-y2)*(x3-x4)
		g = gcd(iyn, iyd);
		if(g == 0) g = 1;
		iyn/=g;
		iyd/=g;
		if(iyd < 0) {iyd*=-1; iyn*=-1;};
		//System.out.println(iyn + " " + iyd );
		if(ixd*l1[0] <= ixn && ixn <= ixd*l1[2] && ixd*l2[0] <= ixn && ixn <= ixd*l2[2])
		{
			
			if((ixn != ixd*l1[0] || iyn != iyd*l1[1])
					&& (ixn != ixd*l1[2] || iyn != iyd*l1[3])
					&& (ixn != ixd*l2[0] || iyn != iyd*l2[1])
					&& (ixn != ixd*l2[2] || iyn != iyd*l2[3])
					) //not on endpoints
			{
				if(ixn == 0) ixd = 1;
				if(iyn == 0) iyd = 1;
				return new Long []{ixn, ixd, iyn, iyd};
			}
			
		}
		return null;
		
	}
	
	public static Long[] fI(int[] l1, int[] l2)
	{
		if(l1[0] > l1[2]) l1 = new int[]{l1[2], l1[3], l1[0], l1[1]}; //sort intervals right to left
		if(l2[0] > l2[2]) l2 = new int[]{l2[2], l2[3], l2[0], l2[1]};
		long x1 = l1[0], y1 = l1[1], x2 = l1[2], y2 = l1[3];
		long x3 = l2[0], y3 = l2[1], x4 = l2[2], y4 = l2[3];
		
		long ixn = (x1*y2-y1*x2)*(x3-x4)-(x1-x2)*(x3*y4-y3*x4);
		long ixd = (x1-x2)*(y3-y4)-(y1-y2)*(x3-x4);
		long g = gcd(ixn, ixd); if(g == 0) g =1;
		ixn/=g; ixd/=g;
		if(ixd < 0) {ixd*=-1; ixn*=-1;};
		
		long iyn = (x1*y2-y1*x2)*(y3-y4)-(y1-y2)*(x3*y4-y3*x4);
		long iyd = (x1-x2)*(y3-y4)-(y1-y2)*(x3-x4);
		g = gcd(iyn, iyd);  if(g == 0) g=1;
		iyn/=g; iyd/=g;
		if(iyd < 0) {iyd*=-1; iyn*=-1;}
		
		if(ixd == 0) return null;
		if(ixn == 0) ixd = 1;
		if(iyn == 0) iyd = 1;
		long minx = x1 > x3 ? x1 : x3;
		long maxx = x2 < x4 ? x2 : x4; 
		if(minx*ixd <= ixn && ixn <= ixd*maxx)
		{
			
			if((ixn != ixd*x1 || iyn != iyd*y1)
					&& (ixn != ixd*x2 || iyn != iyd*y2)
					&& (ixn != ixd*x3 || iyn != iyd*y3)
					&& (ixn != ixd*x4 || iyn != iyd*y4)
					) //not on endpoints
			{
				
				return new Long[]{ixn, ixd, iyn, iyd};
			}
			
		}
		return null;
		
	}
	public static long gcd(long a, long b)
	{
		return b == 0? a : gcd(b, a%b);
	}
}
