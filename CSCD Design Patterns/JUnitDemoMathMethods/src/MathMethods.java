
public class MathMethods {
	
	public static int sumFrom1ThroughN(int n) {
		
		int sum = 0;
		for (int i = 1; i <= n; i++)
			sum += i;
		
		return sum;
	}
	
	public static int factorial(int n) {
		if (n < 0)
			throw new IllegalArgumentException("negative value passed to factorial: " + n);
		
		int fact = 1;
		
		for (int i = 1; i <=n; i++)
			fact *= i;
		return fact;
	}
}
