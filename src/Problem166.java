/*
 * define the grid as:
 * a b c d
 * e f g h
 * i j k l
 * m n o p
 * 
 * Let N be the sum of each row / column / diagonal
 * Equations:
 * a + b + c + d = N
 * e + f + g + h = N
 * i + j + k + l = N
 * m + n + o + p = N
 * a + e + i + m = N
 * b + f + j + n = N
 * c + g + k + o = N
 * d + h + l + p = N
 * a + f + k + p = N
 * d + g + j + m = N
 * 
 * We have 16 variables, we want to reduce this to something more manageable. Perhaps 8 or 9 independent variables.
 * Here is a simplified form:
 * a-g and i are independent (8 independent)
 * the rest:
 * h = a + b + c + d - e - f -g 
 * j = a - d + e - g + i
 * k = b + c + 2*d - e - f - i
 * l = f + g - i
 * m = b + c + d - e - i
 * n = c + 2*d - e - f + g - i
 * o = a - c - d + e + f - g + i
 * p = -d + e + i
 * N = a + b + c + d
 * 
 * iterate over the 10^8 possibilites for a,b,c,d,e,f,g,i
 * Test if the rest are valid
 */
public class Problem166 {
	public static void main(String[] args)
	{ 
		int[] ind = new int[8];
		long ctr=0;
		for(int a = 0; a < 10; a++)
		{
			for(int b = 0; b < 10; b++)
			{
				for(int c = 0; c < 10; c++)
				{
					for(int d = 0; d < 10; d++)
					{
						for(int e = 0; e < 10; e++)
						{
							for(int f = 0; f < 10; f++)
							{
								for(int g = 0; g < 10; g++)
								{
									for(int i=0; i< 10; i++)
									{
										int h = a + b + c + d - e - f -g;
										int j = a - d + e - g + i;
										int k = b + c + 2*d - e - f - i;
										int l = f + g - i;
										int m = b + c + d - e - i;
										int n = c + 2*d - e - f + g - i;
										int o = a - c - d + e + f - g + i;
										int p = -d + e + i;
										int N = a + b + c + d;
										int[] vals = {h, j, k, l, m, n, o, p};
										boolean t = true;
										for(int z = 0; z<vals.length; z++)
										{
											if(vals[z] < 0 || vals[z] > 9)
											{
												t = false;
												break;
											}
										}
										
										if(t) ctr++;
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(ctr);
	}
	
}
