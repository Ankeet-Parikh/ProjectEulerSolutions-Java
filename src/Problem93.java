import java.util.HashMap;
import java.util.Stack;

/*
 * For any set of 4 digits {a,b,c,d}, it is possible to generate integer targets
 * using the basic arithmetic operations {+,-,*,/}. This program finds the set of 4 digits
 * which generate the longest consecutive set of integer targets starting at one.
 * 
 * In order to efficiently generate all possible integer targets, we need an organized way 
 * of generating the expressions. 
 * There are three aspects to the expression: 
 * 1. The four integers
 * 2. The operations on those integers
 * 3. The order of those operations (the parentheses)
 * 
 * Here is an example:
 * 1. The four integers are  {5, 8, 3, 9} (notice that the order matters)
 * 2. The operations are  {1, 2, 3} (1 corresponds to +, 2 to -, 3 to *, 4 to /)
 * 3. The order is {3,1,2}
 * 
 * Here is how the string would look for that:  5+((8-3)*9)
 * This evaluates to 50.
 * Using parentheses to determine the order of operations is confusing, we can
 * simplify it by converting to postfix:
 * 5 8 3 - 9 * +
 * 
 * If we look at the four digits and the operations, we see that there are 5 possibilities of what
 * the string could look like in postfix. Let {a,b,c,d} be the digits and o signify an operation:
 * a b o c o d o
 * a b o c d o o
 * a b c o o d o
 * a b o c d o o
 * a b c d o o o
 * 
 * 
 * We need to generate every set of 4 distinct digits, then find each of their target integer lengths
 */
public class Problem93 {
	static int[] digits = new int[4];
	static boolean[] targets = new boolean[100];
	public static void main(String[] args) throws Exception
	{
		
		HashMap<Integer, Character> ops = new HashMap<Integer, Character>();
		ops.put(1, '+');
		ops.put(2, '-');
		ops.put(3, '*');
		ops.put(4, '/');
		int maxlen = 0;
		String ans = "";
		for(int a = 1; a<=6; a++)
		{
			
			for(int b = a+1; b<=7;b++)
			{
				
				for(int c = b+1; c<=8; c++)
				{
					
					for(int d = c+1; d<=9; d++)
					{
						
						digits[0] = a;
						digits[1] = b;
						digits[2] = c;
						digits[3] = d;
						for(int i=1; i < targets.length; i++) targets[i] = false;
						do{
							for(int o1 = 1; o1 <=4; o1++)
							{
								for(int o2 = 1; o2 <=4; o2++)
								{
									for(int o3 = 1; o3<=4; o3++)
									{
										char f = ops.get(o1), s = ops.get(o2), t = ops.get(o3);
										/*
										 * a b o c o d o
										 * a b o c d o o
										 * a b c o o d o
										 * a b c o d o o
										 * a b c d o o o
										 */
										int l = digits[0];
										int m = digits[1];
										int n = digits[2];
										int p = digits[3];
										String s1 = ""+l+m+f+n+s+p+t;
										String s2 = ""+l+m+f+n+p+s+t;
										String s3 = ""+l+m+n+f+s+p+t;
										String s4 = ""+l+m+n+f+p+s+t;
										String s5 = ""+l+m+n+p+f+s+t;
										//System.out.println(s1);
										postfix(s1);
										postfix(s2);
										postfix(s3);
										postfix(s4);
										postfix(s5);
									}
								}
							}
						}while(nextLex(digits) != 0);
						int i =1;
						while(targets[i])
						{
							i++;
						}
						if(i > maxlen)
						{
							maxlen = i;
							ans = ""+a+b+c+d;
						}
					}
				}
			}
		}
		System.out.println(maxlen);
		System.out.println(ans);
	}
	
	public static int nextLex(int[] a)
	{
		//transforms a into its next lexicographic permutation
		//return 0 if last permutation, 1 otherwise
		int k = a.length-2;
		if(k < 0) return 0;
		for(;k>=0;k--) if(a[k] < a[k+1]) break;
		if(k < 0) return 0;
		int l = a.length-1;
		for(;l>=0;l--) if(a[k] < a[l]) break;
		int t = a[k];
		a[k] = a[l];
		a[l] = t;
		k++;
		int j = a.length-1;
		while(k<j)
		{
			int tmp = a[k];
			a[k] = a[j];
			a[j] = tmp;
			k++;
			j--;
		}
		return 1;
	}
	
	public static void print(int[] a)
	{
		for(int i =0; i<a.length; i++) System.out.print(a[i] +" ");
		System.out.println("");
	}
	public static void postfix(String s)
	{
		//postfix evaluator for this circumstance
		Stack<Float> stack = new Stack<Float>();
		for(int i=0; i<s.length(); i++)
		{
			char c = s.charAt(i);
			if(Character.isDigit(c))
			{
				int v = Character.getNumericValue(c);
				stack.push((float)v);
			}
			else
			{
				float b = stack.pop();
				float a = stack.pop();
				if(c == '+') stack.push(a+b);
				if(c == '-') stack.push(a-b);
				if(c == '*') stack.push(a*b);
				if(c == '/') {
					if(b == 0) return;
					stack.push(a/b);
				}
			}
		}
		float res = stack.pop();
		if(res < 0) return;
		if(res == (int)res && res < 100)
		{
			//System.out.println(s + "     " + res);
			targets[(int)res] = true;
		}
	}
	
	
}
