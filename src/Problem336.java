
public class Problem336 {
	public static void main(String[] args)
	{
		int l = 11;
		int fac = 1;
		for(int i=1; i<=l; i++) fac*=i;
		int ops[] = new int[fac];
		String a = "";
		for(int i = 0; i<l; i++)
			a+=(char)(i+65);
		System.out.println(a);
	}
}
