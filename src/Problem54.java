import java.io.*;
import java.util.*;


public class Problem54{
	public static String l = "23456789TJQKA";
	public char[] n;
	public char[] s;
	
	public Problem54(char[] numbers, char[] suits)
	{
		/*
		 * Object Problem54 will hold both the numbers and the suits
		 */
		this.n = numbers;
		this.s = suits;
		this.sort();
	}
	public static Problem54[] parse(String deal)
	{
		/*
		 * Takes in a string like: 8C TS KC 9H 4S 7D 2S 5D 3S AC
		 * And returns 2 Problem54 objects as such:
		 * {
		 * {{8, T, K, 9, 4},
		 * 	{C, S, C, H, S}},
		 * {{7, 2, 5, 3, A},
		 * 	{D, S, D, S, C}}
		 * }
		 */
		String[] d = deal.split(" ");
		char[] n1 = new char[5];
		char[] s1 = new char[5];
		char[] n2 = new char[5];
		char[] s2 = new char[5];
		for(int i=0; i<5; i++)
		{
			n1[i] = d[i].charAt(0);
			s1[i] = d[i].charAt(1);
			n2[i] = d[i+5].charAt(0);
			s2[i] = d[i+5].charAt(1);
		}
		Problem54 p1 = new Problem54(n1,s1), p2 = new Problem54(n2,s2);
		Problem54[] ret = {p1,p2};
		return ret;
		
		
	}
	public String toString()
	{
		String s = "";
		for(int i=0; i<5; i++)
		{
			s+= this.n[i] +"" + this.s[i] +" ";
		}
		return s;
	}
	public void sort()
	{
		
		for(int i=0; i<5; i++)
		{
			for(int j =0; j<this.n.length-1; j++)
			{
				if(l.indexOf(this.n[j]) > l.indexOf(this.n[j+1]))
				{
					char temp1 = this.n[j];
					this.n[j] = this.n[j+1];
					this.n[j+1] = temp1;
					temp1 = this.s[j];
					this.s[j] = this.s[j+1];
					this.s[j+1] = temp1;
				}
			}
		}
		
	}
	
	

	public int compareTo(Problem54 c) {
		int p1 = getPoints(this);
		int p2 = getPoints(c);
		if(p1 > p2) return 1;
		if(p1 < p2) return -1;

		
		else //p1 and p2 are equal
		{	
			char[] x = null, y = null;
			switch(p1)
			{
			case 1: return compareHighest(this, c);
			case 2:	x = this.OnePair();
					y = c.OnePair(); 
				    if(l.indexOf(x[0]) > l.indexOf(y[0])) return 1;
				    if(l.indexOf(x[0]) < l.indexOf(y[0])) return -1;
				    return compareHighest(this,c);
			case 3: x = this.TwoPairs();
					y = c.TwoPairs();
					if(l.indexOf(x[0]) > l.indexOf(y[0])) return 1;
					if(l.indexOf(x[0]) < l.indexOf(y[0])) return -1;
					if(l.indexOf(x[1]) > l.indexOf(y[1])) return 1;
					if(l.indexOf(x[1]) < l.indexOf(y[1])) return -1;
					return compareHighest(this,c);
			case 4: x = this.ThreeOfAKind();
					y = c.ThreeOfAKind();
					if(l.indexOf(x[0]) > l.indexOf(y[0])) return 1;
					if(l.indexOf(x[0]) < l.indexOf(y[0])) return -1;
					return compareHighest(this,c);
			case 5: return compareHighest(this,c);
			case 6: return compareHighest(this,c);
			case 7: x = this.FullHouse();
					y = c.FullHouse();
					if(l.indexOf(x[0]) > l.indexOf(y[0])) return 1;
					if(l.indexOf(x[0]) < l.indexOf(y[0])) return -1;
					if(l.indexOf(x[1]) > l.indexOf(y[1])) return 1;
					if(l.indexOf(x[1]) < l.indexOf(y[1])) return -1;
					return compareHighest(this,c);
			case 8: x = this.FourOfAKind();
					y = this.FourOfAKind();
					if(l.indexOf(x[0]) > l.indexOf(y[0])) return 1;
					if(l.indexOf(x[0]) < l.indexOf(y[0])) return -1;
					return compareHighest(this, c);
			case 9: return compareHighest(this,c);
			}
		}
		return 0;
	}
	
	public static int compareHighest(Problem54 a, Problem54 b)
	{
		/*
		 * return 1 if a > b or -1 if b > a
		 */
		for(int i=4; i>=0; i--)
		{
			int u = l.indexOf(a.n[i]) ;
			int v = l.indexOf(b.n[i]);
			if(u>v) return 1;
			if(u<v) return -1;
			
		}
		return 0;
	}
	public static int getPoints(Problem54 p)
	{
		if(p.RoyalFlush())    return 10;
		if(p.StraightFlush()) return 9;
		if(p.FourOfAKind() != null)  return 8;
		if(p.FullHouse() != null)     return 7;
		if(p.Flush())         return 6;
		if(p.Straight()) 	  return 5;
		if(p.ThreeOfAKind() != null)  return 4;
		if(p.TwoPairs() != null) 	  return 3;
		if(p.OnePair() != null) 	  return 2;
		return 1;
		
		
	}
	public boolean RoyalFlush()
	{
		return this.StraightFlush() && new String(this.n).trim().equals("TJQKA");
	}
	public boolean StraightFlush()
	{
		return this.Straight() && this.Flush();
	}
	
	public char[] FourOfAKind() 
	{
		if(this.n[0] == this.n[1] && this.n[1] == this.n[2]
				&& this.n[2] == this.n[3]) return new char[]{this.n[2]};
		if(this.n[1] == this.n[2] && this.n[2] == this.n[3]
				&& this.n[3] == this.n[4]) return new char[]{this.n[2]};
		return null;
	}
	public char[] FullHouse()
	{
		/*
		 * returns  {<card repeated thrice>, <card repeated twice>}
		 */
		if(this.n[0] == this.n[1] && this.n[1] == this.n[2] 
				&& this.n[3] == this.n[4]) return new char[]{this.n[1], this.n[3]};
		if(this.n[0] == this.n[1] && this.n[2] ==this.n[3]
				&& this.n[3] == this.n[4]) return new char[]{this.n[2], this.n[1]};
		return null;
	}
	public boolean Flush()
	{
		char m = this.s[0];
		for(int i=1; i<5; i++)
		{
			if(this.s[i] != m) return false;
		}
		return true;
	}
	public boolean Straight()
	{
		for(int i =1; i<5; i++)
		{
			if(l.indexOf(this.n[i]) - l.indexOf(this.n[i-1]) != 1)
				return false;
		}
		return true;
	}
	public char[] ThreeOfAKind()
	{
		//no need to check 4 because 4 of a kind wold have already checked that
		if(this.n[0] == this.n[1] && this.n[1] == this.n[2]) return new char[]{this.n[2]};
		if(this.n[1] == this.n[2] && this.n[2] == this.n[3]) return new char[]{this.n[2]};
		if(this.n[2] == this.n[3] && this.n[3] == this.n[4]) return new char[]{this.n[2]};
		return null;
	}
	public char[] TwoPairs()
	{
		//if found, returns the {higher pair, lower pair}
		boolean foundOne = false;
		char[] pairs = new char[2];
		for(int i=1; i<5; i++)
		{
			if(this.n[i] == this.n[i-1])
			{
				if(!foundOne) 
				{
					pairs[1] = this.n[i];
					i++;
					foundOne = true;
				}
				else
				{
					pairs[0] = this.n[i];
					return pairs;
				}
				
			}
		}
		return null;
	}
	public char[] OnePair()
	{	
		//look for only one pair, if two are found, twopairs would have checked that
		for(int i=1; i< 5; i++)
		{
			if(this.n[i] == this.n[i-1])
			{
				return new char[]{this.n[i]};
			}
		}
		return null;
	}
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan= new Scanner(new File("src/poker.txt"));
		int c =0;
		while(scan.hasNext())
		{
			String line = scan.nextLine();
			Problem54[] x = parse(line);
			if(x[0].compareTo(x[1])  == 1) c++;
		}
		System.out.println(c);
		
	}
	

}
