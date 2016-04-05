
public class Problem191 {
	public static void main(String[] args)
	{
		int l = 4;
		char[] op = {'O', 'A', 'L'};
		int ct = 0;
		for(int i=0; i<Math.pow(3, l); i++)
		{
			String s = Integer.toString(i, 3);
			while(s.length() < l)
			{
				s = "0" + s;
			}
			String p = "";
			for(int j=0; j<s.length(); j++)
			{
				p += op[(int)(s.charAt(j) - '0')];
			}
			if(prize(p)) 
			{
				//System.out.println(p);
				ct++;
			}
		}
		//System.out.println(ct);
		System.out.println(count(30));
	}
	//returns true iff s is a prize string
	public static boolean prize(String s)
	{
		if(s == null) return false;
		if(s.contains("AAA")) return false;
		int l = 0;
		for(int i=0; i < s.length(); i++)
		{
			if('L' == s.charAt(i))
			{
				l++;
			}
		}
		if(l > 1) return false;
		return true;
	}
	
	public static long count(int days)
	{
		long c = 0;
		long[][] dp = new long[6][days+1];
		dp[0][1] = 1; //dp[0][x] is number of ways of length x to end in no absences and have no lates
		dp[1][1] = 1; //dp[1][x] is number of ways of length x to end in 1 absence and have no lates
		dp[2][1] = 0; //dp[2][x] is number of ways of length x to end in 2 absences and have no lates
		dp[3][1] = 1; //dp[3][x] is number of ways of length x to end in no absences and have 1 late
		dp[4][1] = 0; //dp[4][x] is number of ways of length x to end in 1 absence and have 1 late
		dp[5][1] = 0; //dp[5][x] is number of ways of length x to end in 2 absences and have 1 late
		for(int i=2; i < dp[0].length; i++)
		{
			dp[0][i] = dp[0][i-1] + dp[1][i-1] +dp[2][i-1]; 
			dp[1][i] = dp[0][i-1];
			dp[2][i] = dp[1][i-1];
			dp[3][i] = dp[0][i-1] + dp[1][i-1] + dp[2][i-1] + dp[3][i-1] + dp[4][i-1] + dp[5][i-1]; //add "L" and "O"
			dp[4][i] = dp[3][i-1]; //add an "A" to the end
			dp[5][i] = dp[4][i-1]; //add another "A" to the end
		}
		for(int i = 0; i<6; i++)
		{
			c+=dp[i][dp[0].length-1];
		}
		return c;
	}
}
