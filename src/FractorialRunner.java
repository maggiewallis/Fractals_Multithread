
public class FractorialRunner 
{
	public static void main(String[] args)
	{
		System.out.println(factorial(5));
		
		
		stringTrimmer("Hello!");
	}
	
	
	public static int factorial (int N)
	{
		if (N==1)
			return 1;
		return N * factorial(N-1);
		
	}
	
	public static void stringTrimmer (String s)
	{
		if (s.length() ==0 )
			return;
		
		System.out.println(s.substring(0, 1));
		stringTrimmer(s.substring(1));
	}
	
	
	
}



