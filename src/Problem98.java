
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem98 {

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("src/p098_words.txt"));
		String s = scan.nextLine();
		String[] words = s.split(",");
		//remove quotation marks
		for(int i=0; i<words.length; i++)
			words[i] = words[i].replaceAll("\"", "");
		
		//create groups of anagrams
		ArrayList<ArrayList<String>> ana = new ArrayList<ArrayList<String>>(0);
		ArrayList<String> init = new ArrayList<String>(0);
		init.add(words[0]);
		ana.add(init);
		
		for(int i=1; i<words.length; i++)
		{
			boolean next= true;
			for(int j=0; j<ana.size(); j++)
			{
				if(isAnagram(ana.get(j).get(0), words[i]))
				{
					next = false;
					ana.get(j).add(words[i]);
				}
			}
			if(next)//add a new group with the word
			{
				ArrayList<String> n = new ArrayList<String>(0);
				n.add(words[i]);
				ana.add(n);
			}
		}
		
		//remove lists with only one element
		
		for(int i =0; i<ana.size();)
		{
			if(ana.get(i).size() ==1) 
				ana.remove(i);
			else 
			{
				//System.out.println(ana.get(i));
				i++;
			}
				
		}
		//disregard the group with three words in it, it won't have the highest square anyway
		int max =0;
		for(int i=0; i<ana.size(); i++)
		{
			int x = MaxAnagramSquare(ana.get(i).get(0), ana.get(i).get(1));
			
			if(x>max) max =x;
		}
		System.out.println(max);
		
	}
	public static int MaxAnagramSquare(String a, String b) //a and b are anagrams of each other
	{
		int p = a.length() ; //number of digits in a
		int l = (int)Math.ceil(Math.sqrt(Math.pow(10, p-1))); //lowest value so l*l >= 10^(p-1)
		int u = (int)Math.floor(Math.sqrt(Math.pow(10,p))); //largest value so u*u <=10^p
		int max =0; 
		
		for(int i =l; i<=u;i++)
		{
			int aval = i*i;
			if(!isValidMapping(a, aval)) continue;
			//the value of i*i will correspond to string a, so we need to find out the value corresponding to b
			int bval = otherVal(a, b, aval);
			//assure that bval and aval are the same length: is case the first digit of bval was zero, it will be 1 digit shorter
			if((int)Math.log(aval) != (int)Math.log(bval)) continue;
			//see if the value for b is a perfect square
			double rt = Math.sqrt(bval);
			if(rt == (int)rt)
			{
				if(aval > max) max =aval;
				if(bval > max) max =bval;
			}
			
		}
		return max;
		
	}
	
	public static int otherVal(String a, String b, int v1)
	{
	/*integer value of the other word in the anagram
	 * If CARE is 1296, and we want to find the value of RACE
	 * The method will return 9216
	*/
		String av = v1+"";
		String bv = "";
		for(int j=0; j<b.length(); j++)
		{
			String t = b.substring(j, j+1);
			for(int k=0;k<a.length(); k++)
			{
				String curr = a.substring(k, k+1);
				if(curr.equals(t))
				{
					bv+=av.substring(k,k+1);
					break;
				}
			}
		}
		return Integer.parseInt(bv);
	
		
	}
	
	public static boolean isValidMapping(String a, int aval) 
	{
		//make sure the same letter doesn't have two different numbers or
		//the same number isn't mapped to two different letters
		String av = aval+"";
		HashMap<String, Integer> h = new HashMap();
		for(int i=0;i<a.length(); i++)
		{
			String key = a.substring(i, i+1);
			int val = Integer.parseInt(av.substring(i,i+1));
			
			for(String s : h.keySet())
			{
				if(s.equals(key))
				{
					if(!(h.get(s)==val))
					{
						return false;//same letter has a different value
						
					}
				}
				if(h.get(s) == val)
				{
					if(!s.equals(key))
					{
						return false;//same value has a different key
					}
				}
			}
			h.put(key,val);			
		}
		
		return true;
		
	}
	public static boolean isAnagram(String a, String b)
	{
		char[] c = a.toCharArray();
		char[] d = b.toCharArray();
		Arrays.sort(c);
		Arrays.sort(d);
		String e = new String(c);
		String f = new String(d);
		return f.equals(e);
		
	}	
}
