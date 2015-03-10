
public class Problem79 {
	/*
	 * I did this problem with paper and pencil.
	 * First, we see that 4 and 5 do not appear in the tet file, so
	 * they will not appear in our answer.
	 * 
	 * The number zero always appears in the last place, so we can 
	 * safely assume that it will be at the end.
	 * Nine appears usually at the end, but if zero is there, it will come before it.
	 * Eight appears only with 9 and 0 after it, so that will come before 9.
	 * So far we have ~890.
	 * The only numbers after 2 are 8,9, and zero, so put that before 8.
	 * ~2890
	 * Seven appears only in the front.
	 * 7~2890
	 * We have one and three remaining. ( these numbers technically speaking could appear multiple
	 * times, but they don't, as seen below).
	 * One never appears before 3, so we can assume that 31 is the last part of the passcode.
	 * Finally we have 73162890
	 */
	public static void main(String[] args)
	{
		System.out.println("73162890");
	}
}
