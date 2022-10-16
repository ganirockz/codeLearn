package basics;

public class BasicsMain {
	public static void main(String[] args) {
		BasicMaths b = new BasicMaths();
		long startTime = System.nanoTime();
		//System.out.println(b.countDigits(300));
		//System.out.println(b.numberReverse(102));
		//System.out.println(b.isPalindrom(101));
		//System.out.println(b.gcd(6,16));
		
		//System.out.println(b.armstrongNumber(153));
		//b.divisors(102);
		System.out.println(b.isPrime(102));
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		duration = duration /10000;
		System.out.println("Total duration: "+ duration+"ms");
	}
}
