/*
 * We need only consider equal size disjoint sets for this problem.
 * Take n = 4: {a, b, c, d}
 * There are 6 pairs of 1 element subsets: a and b, a and c, a and d, b and c, b and d, c and d
 * None need to be tested for equality, we know that because of the "strictly increasing numbers" rule
 * There are 3 pairs of 2 element subsets:
 * ab and cd
 * ac and bd
 * ad and bc
 * We know that in the first two, the latter sets will always have a higher sum. But in the last pair
 * ad and bc can be equal
 * 
 * For n = 5: {a, b, c, d, e}
 * We have 5 pairs that need to be checked for equality:
 * ad and bc
 * ae and bc
 * ae and bd
 * ae and cd
 * be and cd
 * 
 * we can create the disjoint pairs using ternary strings 
 * For example
 * ad and bc would be represented as such
 * {a, b, c, d, e}
 *  1  2  2  1  0
 *  generate all ternary strings of length n
 */
public class Problem106 {
	public static void main(String[] args)
	{
		int n = 12;
		String set = "";
		for(int i=0; i<n; i++) set+=(char)('a'+i);
		int up = (int)Math.pow(3, n);
		int c = 0;
		for(int i=1; i<up; i++)
		{
			String s = Integer.toString(i, 3);
			
			if(usable(s))
			{
				String s1 = "", s2 ="";
				while(s.length() < n){s = "0"+s;}
				//System.out.println(s);
				for(int j = 0; j < s.length(); j++)
				{
					if(s.charAt(j) == '1') s1+=set.charAt(j);
					if(s.charAt(j) == '2') s2+=set.charAt(j);
				}
				int w1 = 0, w2 = 0;
				for(int j=0; j<s1.length(); j++)
				{
					if(s1.charAt(j) > s2.charAt(j)) w1++;
					else w2++;
				}
				if(w1 >0 && w2 > 0) c++;
			}
		}
		System.out.println(c/2);
	}
	
	public static boolean usable(String s)
	{
		int o = 0, t = 0;
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i) == '1') o++;
			if(s.charAt(i) == '2') t++;
		}
		return o == t && o > 1;
	}
}
